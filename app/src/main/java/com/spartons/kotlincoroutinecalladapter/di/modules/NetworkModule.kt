package com.spartons.kotlincoroutinecalladapter.di.modules

import android.content.Context
import com.spartons.kotlincoroutinecalladapter.di.qualifiers.ApplicationContextQualifier
import com.spartons.kotlincoroutinecalladapter.di.scopes.CustomApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit

@Module(includes = [(ApplicationContextModule::class)])
class NetworkModule {

    @Provides
    @CustomApplicationScope
    fun getInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor {
            Timber.i(it)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @CustomApplicationScope
    fun getCache(cacheFile: File) = Cache(cacheFile, 10 * 1000 * 1000)   // 10 Mib cache

    @Provides
    @CustomApplicationScope
    fun getFile(@ApplicationContextQualifier context: Context): File {
        val file = File(context.filesDir, "cache_dir")
        if (!file.exists())
            file.mkdirs()
        return file
    }

    @Provides
    @CustomApplicationScope
    fun getOkHttpClient(interceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .writeTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .cache(cache)
            .addInterceptor(interceptor)
            .build()
    }
}