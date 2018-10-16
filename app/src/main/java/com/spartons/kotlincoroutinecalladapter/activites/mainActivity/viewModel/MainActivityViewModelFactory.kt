package com.spartons.kotlincoroutinecalladapter.activites.mainActivity.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.dataSource.MovieDataSource

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory constructor(private val movieDataSource: MovieDataSource) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = MainActivityViewModel(movieDataSource) as T
}