package dev.plastikrab.weatherapp.data.api


import dev.plastikrab.weatherapp.data.api.dto.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("APPID") apiKey: String
    ): Response<WeatherDto>

    @GET()
    suspend fun getForecast(lat: Double, lon: Double): Response<List<WeatherDto>>
}