package com.spartons.kotlincoroutinecalladapter.backend

import android.app.Application
import com.spartons.kotlincoroutinecalladapter.di.components.AppComponent
import com.spartons.kotlincoroutinecalladapter.di.components.DaggerAppComponent
import com.spartons.kotlincoroutinecalladapter.di.modules.ApplicationContextModule
import timber.log.Timber

class MyCustomApplicationClass : Application() {

    private lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        applicationComponent = DaggerAppComponent
            .builder()
            .applicationContextModule(ApplicationContextModule(this))
            .build()
    }

    fun getAppComponent() = applicationComponent
}