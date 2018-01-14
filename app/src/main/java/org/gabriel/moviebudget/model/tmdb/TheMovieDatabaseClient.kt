package org.gabriel.moviebudget.model.tmdb

import rx.Observable

interface TheMovieDatabaseClient {
    fun retrieveConfiguration(): Observable<Configuration>

    fun searchMovie(
            query: String,
            language: String? = null,
            page: Int? = null,
            includeAdult: Boolean? = null,
            region: String? = null,
            year: Int? = null,
            primaryReleaseYear: Int? = null
    ): Observable<SearchResults>

    fun movieDetails(
            id: String,
            language: String? = null,
            appendToResponse: String? = null
    ): Observable<Movie>
}

