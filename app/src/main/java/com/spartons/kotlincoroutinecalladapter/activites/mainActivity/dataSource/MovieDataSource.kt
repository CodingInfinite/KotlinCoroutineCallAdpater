package com.spartons.kotlincoroutinecalladapter.activites.mainActivity.dataSource

import com.spartons.kotlincoroutinecalladapter.backend.ApiService
import com.spartons.kotlincoroutinecalladapter.response.MovieResponse
import com.spartons.kotlincoroutinecalladapter.response.Result
import com.spartons.kotlincoroutinecalladapter.util.safeApiCall
import java.io.IOException

@Suppress("EXPERIMENTAL_FEATURE_WARNING")
class MovieDataSource constructor(private val apiService: ApiService) {

    companion object {
        private const val API_KEY = "e5c7041*****************0e80c7"
    }

    suspend fun getMovies(pageNumber: Int) = safeApiCall(
        call = { popularMovies(pageNumber) },
        errorMessage = "Error occurred"
    )

    private suspend fun popularMovies(pageNumber: Int): Result<MovieResponse> {
        val response = apiService.getPopular(API_KEY, pageNumber).await()
        if (response.isSuccessful)
            return Result.Success(response.body()!!)
        return Result.Error(IOException("Error occurred during fetching movies!"))
    }
}
