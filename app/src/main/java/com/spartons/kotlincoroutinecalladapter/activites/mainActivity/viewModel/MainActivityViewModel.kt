package com.spartons.kotlincoroutinecalladapter.activites.mainActivity.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.dataSource.MovieDataSource
import com.spartons.kotlincoroutinecalladapter.response.MovieResponse
import com.spartons.kotlincoroutinecalladapter.response.Result
import com.spartons.kotlincoroutinecalladapter.util.NonNullMediatorLiveData
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

@Suppress("EXPERIMENTAL_FEATURE_WARNING")
class MainActivityViewModel constructor(private val movieDataSource: MovieDataSource) : ViewModel() {

    private val _movies = NonNullMediatorLiveData<List<MovieResponse.Movie>>()
    private val _error = NonNullMediatorLiveData<String>()

    private var moviesJob: Job? = null

    val movies: LiveData<List<MovieResponse.Movie>> get() = _movies
    val error: LiveData<String> get() = _error

    init {
        initGetMoviesCall()
    }

    private fun initGetMoviesCall() {
        moviesJob = launch {
            val value = movieDataSource.getMovies(1)
            when (value) {
                is Result.Success -> _movies.postValue(value.data.movies)
                is Result.Error -> _error.postValue(value.exception.message)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        moviesJob?.cancel()
    }
}
