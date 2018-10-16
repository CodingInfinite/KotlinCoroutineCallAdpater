package com.spartons.kotlincoroutinecalladapter.activites

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import com.spartons.kotlincoroutinecalladapter.backend.MyCustomApplicationClass

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    protected fun getAppComponent() = getApp().getAppComponent()

    private fun getApp() = applicationContext as MyCustomApplicationClass
}