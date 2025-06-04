package dev.plastikrab.weatherapp.domain.repositories

import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainWeather
import dev.plastikrab.weatherapp.domain.states.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface IWeatherRepository {
    suspend fun updateWeather(lat: Double, lon: Double)
    val currentState: StateFlow<ResponseState<DomainWeather>>
}