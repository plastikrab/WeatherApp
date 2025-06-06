package dev.plastikrab.weatherapp.domain.usecases

import dev.plastikrab.weatherapp.domain.entities.forecast.DomainForecast
import dev.plastikrab.weatherapp.domain.repositories.ILocationRepository
import dev.plastikrab.weatherapp.domain.repositories.IWeatherRepository
import dev.plastikrab.weatherapp.domain.states.ResponseState
import javax.inject.Inject

class GetForecastUseCase@Inject constructor(
    private val weatherRepository: IWeatherRepository,
    private val locationRepository: ILocationRepository
) {
    suspend operator fun invoke() : ResponseState<DomainForecast> {
        val location = locationRepository.getCurrentLocation()
        return weatherRepository.getForecast(location.latitude, location.longitude)
    }
}