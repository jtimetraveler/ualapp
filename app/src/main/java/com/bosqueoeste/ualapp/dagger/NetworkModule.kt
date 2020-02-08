package com.bosqueoeste.ualapp.dagger

import com.bosqueoeste.ualapp.BuildConfig
import com.bosqueoeste.ualapp.data.api.UalappApi
import com.bosqueoeste.ualapp.data.api.UalappApiConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRxAdapterFactory() = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideHttpInterceptor(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(UalappApiConfig.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(UalappApiConfig.TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
        }

        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        rxFactory: RxJava2CallAdapterFactory,
        httpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ) =
        Retrofit.Builder()
            .baseUrl(UalappApiConfig.BASE_URL)
            .client(httpClient)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(rxFactory)
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) =
        retrofit.create(UalappApi::class.java)
}