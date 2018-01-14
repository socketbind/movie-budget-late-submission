package org.gabriel.moviebudget.model.tmdb

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface TheMovieDatabaseService {

    @GET("/3/configuration")
    fun retrieveConfiguration(
            @Query("api_key")              apiKey: String
    ): Observable<Configuration>

    @GET("/3/search/movie")
    fun searchMovies(
            @Query("api_key")              apiKey: String,
            @Query("query")                query: String,
            @Query("language")             language: String? = null,
            @Query("page")                 page: Int? = null,
            @Query("include_adult")        includeAdult: Boolean? = null,
            @Query("region")               region: String? = null,
            @Query("year")                 year: Int? = null,
            @Query("primary_release_year") primaryReleaseYear: Int? = null
    ): Observable<SearchResults>

    @GET("/3/movie/{id}")
    fun movieDetails(
            @Path("id")                     id: Int,
            @Query("api_key")                apiKey: String,
            @Query("language")              language: String? = null,
            @Query("append_to_response")    appendToResponse: String? = null
    ): Observable<Movie>

}

