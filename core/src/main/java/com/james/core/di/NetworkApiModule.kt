package com.james.core.di

import com.james.core.BuildConfig
import com.james.core.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient


@Module
@InstallIn(SingletonComponent::class)
class NetworkApiModule {

    @Provides
    fun provideApiServices(): ApiService {
        val certifPinner = CertificatePinner.Builder()
            .add(BuildConfig.HOSTNAME, "sha256/HSg5qOfwUiJuZ+8BnTJfEaEECluaqvKLxzgu3yPjhn4=")
            .add(BuildConfig.HOSTNAME, "sha256/jQJTbIh0grw0/1TkHSumWb+Fs0Ggogr621gT3PvPKG0=")
            .add(BuildConfig.HOSTNAME, "sha256/C5+lpZ7tcVwmwQIMcRtPbsQtWLABXhQzejna0wHFr8M=")
            .build()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .certificatePinner(certifPinner)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
        val retrofitBuild = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofitBuild.create(ApiService::class.java)
    }
}