package org.gabriel.moviebudget

import org.gabriel.moviebudget.injection.TmdbApiKey
import org.gabriel.moviebudget.model.tmdb.DefaultMovieDatabaseClient
import org.gabriel.moviebudget.model.tmdb.TheMovieDatabaseClient
import toothpick.config.Module

class MovieBudgetApplicationModule : Module() {
    init {
        bind(String::class.java).withName(TmdbApiKey::class.java).toInstance(BuildConfig.TMDB_API_KEY)

        bind(TheMovieDatabaseClient::class.java).to(DefaultMovieDatabaseClient::class.java).singletonInScope()
    }
}