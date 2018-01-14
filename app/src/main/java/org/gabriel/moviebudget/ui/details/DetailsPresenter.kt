package org.gabriel.moviebudget.ui.details

import org.gabriel.moviebudget.R
import org.gabriel.moviebudget.model.tmdb.TheMovieDatabaseClient
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class DetailsPresenter @Inject constructor(val view: DetailsContract.View, val client: TheMovieDatabaseClient) : DetailsContract.Presenter {

    private val subscriptions = CompositeSubscription()

    override fun start() {

    }

    override fun stop() {
        subscriptions.unsubscribe()
        subscriptions.clear()
    }

    override fun receivedMovieId(id: Int) {
        view.showProgress()

        val subscription = client.movieDetails(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { movie -> view.showDetails(movie) },
                        { err ->
                            val message = err.message
                            if (message != null) {
                                view.showError(R.string.unable_to_load_details, message)
                            } else {
                                view.showError(R.string.unknown_error)
                            }
                        }

                )

        subscriptions.add(subscription)
    }


}