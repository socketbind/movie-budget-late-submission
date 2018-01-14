package org.gabriel.moviebudget.ui.search

import android.support.annotation.StringRes
import org.gabriel.moviebudget.model.tmdb.Configuration
import org.gabriel.moviebudget.model.tmdb.SearchResults
import org.gabriel.moviebudget.ui.BasePresenter
import org.gabriel.moviebudget.ui.BaseView

interface SearchContract {

    interface View : BaseView<Presenter> {

        fun enableSearch(configuration: Configuration)

        fun showResults(results: SearchResults)

        fun clearError()

        fun showProgress(@StringRes progressRes: Int)

        fun showError(@StringRes errorRes: Int, vararg formatArgs: Any)

        fun showNoResults()

        fun navigateToDetails(movieId: Int)

    }

    interface Presenter : BasePresenter {
        fun querySubmitted(query: String)

    }


}

