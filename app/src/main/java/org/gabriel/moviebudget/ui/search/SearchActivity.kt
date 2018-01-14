package org.gabriel.moviebudget.ui.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.gabriel.moviebudget.R
import org.gabriel.moviebudget.model.tmdb.TheMovieDatabaseClient
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.CompositeSubscription
import toothpick.Scope
import toothpick.Toothpick
import toothpick.smoothie.module.SmoothieActivityModule
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    private lateinit var scope: Scope

    @Inject
    lateinit var client: TheMovieDatabaseClient

    private val subs = CompositeSubscription()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        scope = Toothpick.openScopes(application, this)
        scope.installModules(SmoothieActivityModule(this), SearchModule())
        Toothpick.inject(this, scope)
    }

    override fun onResume() {
        super.onResume()
        subs.add(client.searchMovie("Shawnshank Redemption")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ results ->
                    println(results.totalResults)
                }))
    }

    override fun onPause() {
        super.onPause()
        subs.unsubscribe()
    }

    override fun onDestroy() {
        super.onDestroy()

        Toothpick.closeScope(this)
    }
}
