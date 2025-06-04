package dev.plastikrab.weatherapp.data.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.plastikrab.weatherapp.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherApiContainer {


    @Provides
    @Singleton
    fun getWeatherApi() : WeatherApi {
        val BASE_URL = BuildConfig.serviceUrl

        val client = OkHttpClient.Builder()
            .callTimeout(10, TimeUnit.SECONDS)
            .build()

        val retrofit : Retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        val retrofitService : WeatherApi by lazy {
            retrofit.create(WeatherApi::class.java)
        }

        return retrofitService
    }
}