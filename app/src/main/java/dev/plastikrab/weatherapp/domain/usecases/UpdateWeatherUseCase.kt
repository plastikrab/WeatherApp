package dev.plastikrab.weatherapp.domain.usecases

import dev.plastikrab.weatherapp.domain.repositories.ILocationRepository
import dev.plastikrab.weatherapp.domain.repositories.IWeatherRepository
import javax.inject.Inject

class UpdateWeatherUseCase@Inject constructor(
    private val repository: IWeatherRepository,
    private val locationRepository: ILocationRepository
) {
    suspend operator fun invoke() {
        val location = locationRepository.getCurrentLocation()
        repository.updateWeather(location.latitude, location.longitude)
    }
}