package com.spartons.kotlincoroutinecalladapter.di.components

import com.spartons.kotlincoroutinecalladapter.backend.ApiService
import com.spartons.kotlincoroutinecalladapter.di.modules.PicassoModule
import com.spartons.kotlincoroutinecalladapter.di.modules.ServiceUtilModule
import com.spartons.kotlincoroutinecalladapter.di.scopes.CustomApplicationScope
import com.squareup.picasso.Picasso
import dagger.Component

@CustomApplicationScope
@Component(modules = [PicassoModule::class, ServiceUtilModule::class])
interface AppComponent {

    fun getPicasso(): Picasso

    fun getApiService(): ApiService
}
