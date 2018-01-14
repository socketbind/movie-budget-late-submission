package org.gabriel.moviebudget.ui.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_search.*
import org.gabriel.moviebudget.R
import org.gabriel.moviebudget.model.tmdb.SearchResults
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

    private val resultsAdapter = SearchResultsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        search_results.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = resultsAdapter
        }

        scope = Toothpick.openScopes(application, this)
        scope.installModules(
                SmoothieActivityModule(this),
                SearchModule(this)
        )
        Toothpick.inject(this, scope)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)

        searchView = menu.findItem(R.id.search_movie).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                presenter.querySubmitted(query)
                return true
            }

            override fun onQueryTextChange(newText: String) = false
        })

        searchView.maxWidth = Integer.MAX_VALUE

        return true
    }

    override fun onResume() {
        super.onResume()

        presenter.start()
    }

    override fun onPause() {
        super.onPause()

        presenter.stop()
    }

    override fun onDestroy() {
        super.onDestroy()

        Toothpick.closeScope(this)
    }

    override fun showResults(results: SearchResults) {
        placeholder_text.visibility = View.INVISIBLE
        search_results.visibility = View.VISIBLE

        resultsAdapter.replaceItems(results.results)
    }

    override fun showProgress() {
        placeholder_text.setText(R.string.search_in_progress)
        placeholder_text.visibility = View.VISIBLE
        search_results.visibility = View.INVISIBLE
    }

    override fun showNoResults() {
        placeholder_text.setText(R.string.no_results)
        placeholder_text.visibility = View.VISIBLE
        search_results.visibility = View.INVISIBLE
    }

    override fun showQueryError(errorRes: Int, vararg formatArgs: Any) {
        searchView.setError(errorRes, formatArgs)
    }

    override fun clearQueryError() {
        searchView.setError(null)
    }
}
