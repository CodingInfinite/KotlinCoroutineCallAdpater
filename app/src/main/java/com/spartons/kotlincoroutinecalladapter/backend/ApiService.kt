package com.spartons.kotlincoroutinecalladapter.backend

import com.spartons.kotlincoroutinecalladapter.response.MovieResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(value = "popular")
    fun getPopular(
        @Query(
            value = "api_key"
        ) apiKey: String, @Query(
            value = "page"
        ) page: Int
    ): Deferred<Response<MovieResponse>>
}