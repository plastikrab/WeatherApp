package dev.plastikrab.weatherapp.domain.repositories

import dev.plastikrab.weatherapp.domain.entities.forecast.DomainForecast
import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainWeather
import dev.plastikrab.weatherapp.domain.states.ResponseState
import kotlinx.coroutines.flow.StateFlow

interface IWeatherRepository {
    suspend fun updateWeather(lat: Double, lon: Double)
    suspend fun getForecast(lat: Double, lon: Double): ResponseState<DomainForecast>

    val currentState: StateFlow<ResponseState<DomainWeather>>
}