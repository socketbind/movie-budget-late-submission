package org.gabriel.moviebudget.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_movie_details.*
import org.gabriel.moviebudget.R
import org.gabriel.moviebudget.model.tmdb.Movie
import toothpick.Scope
import toothpick.Toothpick
import toothpick.smoothie.module.SmoothieActivityModule
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    private lateinit var scope: Scope

    @Inject
    override lateinit var presenter: DetailsContract.Presenter

    private var movieId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        scope = Toothpick.openScopes(application, this)
        scope.installModules(
                SmoothieActivityModule(this),
                DetailsModule(this)
        )
        Toothpick.inject(this, scope)

        if (intent.hasExtra(MOVIE_ID_KEY)) {
            movieId = intent.getIntExtra(MOVIE_ID_KEY, 0)
        } else {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        presenter.start()

        presenter.receivedMovieId(movieId)
    }

    override fun showProgress() {
        movie_details.visibility = View.GONE
        details_placeholder.visibility = View.VISIBLE
        details_placeholder.setText(R.string.loading)
    }

    override fun showError(errorRes: Int, vararg formatArgs: Any) {
        movie_details.visibility = View.GONE
        details_placeholder.visibility = View.VISIBLE
        details_placeholder.text = getString(errorRes, *formatArgs)
    }

    override fun showDetails(movie: Movie) {
        movie_details.visibility = View.VISIBLE
        details_placeholder.visibility = View.GONE

        detail_title.text = movie.title
        if (movie.budget != null && movie.budget != 0) {
            detail_budget.text = getString(R.string.known_budget, movie.budget)
        } else {
            detail_budget.setText(R.string.unknown_budget)
        }

        if (!movie.tagline.isNullOrBlank()) {
            detail_tagline.text = movie.tagline
            detail_tagline.visibility = View.VISIBLE
        } else {
            detail_tagline.visibility = View.GONE
        }

        if (!movie.overview.isNullOrBlank()) {
            detail_overview.text = movie.overview
        } else {
            detail_overview.visibility = View.GONE
        }
    }

    override fun onPause() {
        super.onPause()

        presenter.stop()
    }

    override fun onDestroy() {
        super.onDestroy()

        Toothpick.closeScope(this)
    }

    companion object {
        const val MOVIE_ID_KEY = "movie.id"
    }

}