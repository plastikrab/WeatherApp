package dev.plastikrab.weatherapp.domain.usecases

import android.util.Log
import dev.plastikrab.weatherapp.TAG
import dev.plastikrab.weatherapp.domain.repositories.ILocationRepository
import dev.plastikrab.weatherapp.domain.repositories.IWeatherRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class SetUpdaterUseCase@Inject constructor(
    private val weatherRepository: IWeatherRepository,
    private val locationRepository: ILocationRepository
) {
    suspend operator fun invoke() {
        while (true) {
            delay(60 * 1000L)
            Log.d(TAG, "setUpdaterUseCase: Weather update")
            val location = locationRepository.getCurrentLocation()
            weatherRepository.updateWeather(location.latitude, location.longitude)
        }
    }
}