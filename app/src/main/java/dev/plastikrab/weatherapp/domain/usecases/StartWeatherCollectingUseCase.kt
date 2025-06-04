package dev.plastikrab.weatherapp.domain.usecases

import dev.plastikrab.weatherapp.domain.repositories.IWeatherRepository
import javax.inject.Inject

class StartWeatherCollectingUseCase@Inject constructor(
    private val repository: IWeatherRepository
) {
    operator fun invoke() = repository.currentState
}