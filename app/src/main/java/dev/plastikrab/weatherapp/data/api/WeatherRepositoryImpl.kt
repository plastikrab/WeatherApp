package dev.plastikrab.weatherapp.data.api

import android.util.Log
import dev.plastikrab.weatherapp.BuildConfig
import dev.plastikrab.weatherapp.MOCK_JSON
import dev.plastikrab.weatherapp.TAG
import dev.plastikrab.weatherapp.data.api.dto.forecast.ForecastDto
import dev.plastikrab.weatherapp.domain.entities.forecast.DomainForecast
import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainWeather
import dev.plastikrab.weatherapp.domain.repositories.IWeatherRepository
import dev.plastikrab.weatherapp.domain.states.ResponseState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
) : IWeatherRepository {

    val _currentState =
        MutableStateFlow<ResponseState<DomainWeather>>(ResponseState.Loading())
    override val currentState: StateFlow<ResponseState<DomainWeather>> =
        _currentState.asStateFlow()

    override suspend fun updateWeather(
        lat: Double,
        lon: Double
    ) {
        try {
            _currentState.value = ResponseState.Loading()
            Log.d(TAG, "updateWeather: Try to update weather")
            val response = weatherApi.getWeather(
                lat = lat,
                lon = lon,
                apiKey = BuildConfig.apiKey,

            )
            if (response.isSuccessful) {
                response.body()?.let {
                    _currentState.value = ResponseState.Success(it.mapToDomain())
                    Log.d(TAG, "updateWeather: Success")
                }
            } else {
                _currentState.value = ResponseState.Error(response.message())
                Log.d(TAG, "updateWeather: Error")
            }
        } catch (
            e: Exception
        ) {
            _currentState.value = ResponseState.Error<DomainWeather>(e.message ?: "An error occurred")
            e.printStackTrace()
        }
    }

    //Данные к сожалению мокнуты из за проблем с API OpenWeatherMap
    override suspend fun getForecast(
        lat: Double,
        lon: Double
    ): ResponseState<DomainForecast> {
        val json = Json { ignoreUnknownKeys = true }
        return ResponseState.Success(json.decodeFromString<ForecastDto>(MOCK_JSON).mapToDomain())
    }
}