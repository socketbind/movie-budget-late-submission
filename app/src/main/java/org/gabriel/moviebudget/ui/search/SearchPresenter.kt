package org.gabriel.moviebudget.ui.search

import org.gabriel.moviebudget.R
import org.gabriel.moviebudget.model.tmdb.Configuration
import org.gabriel.moviebudget.model.tmdb.SearchResults
import org.gabriel.moviebudget.model.tmdb.TheMovieDatabaseClient
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class SearchPresenter @Inject constructor(val view: SearchContract.View, val client: TheMovieDatabaseClient) : SearchContract.Presenter {

    private val subscriptions = CompositeSubscription()

    override fun start() {
        view.showProgress(R.string.please_wait)

        client.retrieveConfiguration()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            configuration: Configuration -> view.enableSearch(configuration)
                        },
                        {
                            err -> view.showError(R.string.unable_to_retrieve_configuration)
                        }
                )
    }

    override fun stop() {
        subscriptions.unsubscribe()
        subscriptions.clear()
    }

    override fun querySubmitted(query: String) {
        val trimmedQuery = query.trim()

        view.clearError()

        if (trimmedQuery.length < 3) {
            view.showError(R.string.must_be_at_least_three_characters)
            return
        }

        view.showProgress(R.string.search_in_progress)

        val querySubscription = client.searchMovie(trimmedQuery)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { results: SearchResults ->
                            if (results.totalResults > 0) {
                                view.showResults(results)
                            } else {
                                view.showNoResults()
                            }
                        },
                        { err ->
                            val message = err.message
                            if (message != null) {
                                view.showError(R.string.unable_to_retrieve_results, message)
                            } else {
                                view.showError(R.string.unknown_error)
                            }
                        }
                )

        subscriptions.add(querySubscription)
    }

}