package org.gabriel.moviebudget.ui.search

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_search.*
import org.gabriel.moviebudget.R
import org.gabriel.moviebudget.model.tmdb.Configuration
import org.gabriel.moviebudget.model.tmdb.SearchResults
import org.gabriel.moviebudget.ui.details.DetailsActivity
import org.gabriel.moviebudget.ui.search.items.SearchResultsAdapter
import org.gabriel.moviebudget.utils.setError
import toothpick.Scope
import toothpick.Toothpick
import toothpick.smoothie.module.SmoothieActivityModule
import javax.inject.Inject

class SearchActivity : AppCompatActivity(), SearchContract.View {

    private lateinit var scope: Scope

    @Inject
    override lateinit var presenter: SearchContract.Presenter

    private lateinit var searchView: SearchView

    private lateinit var resultsAdapter: SearchResultsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        search_results.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SearchActivity)
        }

        scope = Toothpick.openScopes(application, this)
        scope.installModules(
                SmoothieActivityModule(this),
                SearchModule(this)
        )
        Toothpick.inject(this, scope)

        presenter.start()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)

        searchView = menu.findItem(R.id.search_movie).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                presenter.querySubmitted(query)
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String) = false
        })

        searchView.maxWidth = Integer.MAX_VALUE
        searchView.isEnabled = false

        return true
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.stop()

        Toothpick.closeScope(this)
    }

    override fun showResults(results: SearchResults) {
        placeholder_text.visibility = View.INVISIBLE
        search_results.visibility = View.VISIBLE

        resultsAdapter.replaceItems(results.results)
    }

    override fun showProgress(progressRes: Int) {
        placeholder_text.setText(progressRes)
        placeholder_text.visibility = View.VISIBLE
        search_results.visibility = View.INVISIBLE
    }

    override fun showNoResults() {
        placeholder_text.setText(R.string.no_results)
        placeholder_text.visibility = View.VISIBLE
        search_results.visibility = View.INVISIBLE
    }

    override fun showError(errorRes: Int, vararg formatArgs: Any) {
        searchView.setError(errorRes, *formatArgs)
    }

    override fun clearError() {
        searchView.setError(null)
    }

    override fun enableSearch(configuration: Configuration) {
        placeholder_text.setText(R.string.use_top_search)
        searchView.isEnabled = true

        resultsAdapter = SearchResultsAdapter("${configuration.images.baseUrl}/w500/")
        search_results.adapter = resultsAdapter
    }

    override fun navigateToDetails(movieId: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.MOVIE_ID_KEY, movieId)
        startActivity(intent)
    }

}
