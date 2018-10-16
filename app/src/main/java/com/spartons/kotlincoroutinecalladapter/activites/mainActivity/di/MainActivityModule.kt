package com.spartons.kotlincoroutinecalladapter.activites.mainActivity.di

import android.arch.lifecycle.ViewModelProviders
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.dataSource.MovieDataSource
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.ui.MainActivity
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.viewModel.MainActivityViewModel
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.viewModel.MainActivityViewModelFactory
import com.spartons.kotlincoroutinecalladapter.backend.ApiService
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule constructor(private val mainActivity: MainActivity) {

    @Provides
    @MainActivityScope
    fun movieDataSource(apiService: ApiService) = MovieDataSource(apiService)

    @Provides
    @MainActivityScope
    fun mainActivityViewModelFactory(movieDataSource: MovieDataSource) = MainActivityViewModelFactory(movieDataSource)

    @Provides
    @MainActivityScope
    fun mainActivityViewModel(viewModelFactory: MainActivityViewModelFactory): MainActivityViewModel =
        ViewModelProviders.of(mainActivity, viewModelFactory).get(MainActivityViewModel::class.java)
}