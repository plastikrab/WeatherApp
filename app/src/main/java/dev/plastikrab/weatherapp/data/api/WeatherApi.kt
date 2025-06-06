package dev.plastikrab.weatherapp.data.api


import dev.plastikrab.weatherapp.data.api.dto.forecast.ForecastDto
import dev.plastikrab.weatherapp.data.api.dto.weather.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String
    ): Response<WeatherDto>

    @GET("data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("lat")lat: Double,
        @Query("lon")lon: Double,
        @Query("cnt")cnt: Int = 7,
        @Query("appid")apiKey: String
    ): Response<ForecastDto>
    
}