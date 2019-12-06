package com.example.aidlsampleapp.di.module

import android.content.Context
import com.example.aidlsampleapp.network.PostApi
import com.example.aidlsampleapp.util.BASE_URL
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Ajeena on 06-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
@Module
object NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkHttpCache(application: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }


    @Provides
    @Singleton
    @Named("provideRetrofit")
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
               return  Retrofit.Builder()
                       .baseUrl(BASE_URL)
                       .addConverterFactory(MoshiConverterFactory.create())
                       .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                       .build()
    }

}