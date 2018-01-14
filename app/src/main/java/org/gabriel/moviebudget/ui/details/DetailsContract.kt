package org.gabriel.moviebudget.ui.details

import android.support.annotation.StringRes
import org.gabriel.moviebudget.model.tmdb.Movie
import org.gabriel.moviebudget.ui.BasePresenter
import org.gabriel.moviebudget.ui.BaseView

interface DetailsContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun showError(@StringRes errorRes: Int, vararg formatArgs: Any)

        fun showDetails(movie: Movie)

    }

    interface Presenter : BasePresenter {

        fun receivedMovieId(id: Int)

    }

}