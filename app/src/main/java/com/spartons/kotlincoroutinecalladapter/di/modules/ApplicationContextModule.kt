package com.spartons.kotlincoroutinecalladapter.di.modules

import android.content.Context
import com.spartons.kotlincoroutinecalladapter.di.qualifiers.ApplicationContextQualifier
import com.spartons.kotlincoroutinecalladapter.di.scopes.CustomApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationContextModule(private var context: Context) {

    @Provides
    @CustomApplicationScope
    @ApplicationContextQualifier
    fun getContext() = context
}
