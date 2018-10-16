package com.spartons.kotlincoroutinecalladapter.activites.mainActivity.di

import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.ui.MainActivity
import com.spartons.kotlincoroutinecalladapter.activites.mainActivity.viewModel.MainActivityViewModel
import com.spartons.kotlincoroutinecalladapter.di.components.AppComponent
import dagger.Component

@MainActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [AppComponent::class])
interface MainActivityComponent : AppComponent {

    fun inject(mainActivity: MainActivity)

    fun viewModel(): MainActivityViewModel
}