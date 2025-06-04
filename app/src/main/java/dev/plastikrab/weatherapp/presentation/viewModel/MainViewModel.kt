package dev.plastikrab.weatherapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.plastikrab.weatherapp.TAG
import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainWeather
import dev.plastikrab.weatherapp.domain.states.ResponseState
import dev.plastikrab.weatherapp.domain.usecases.StartWeatherCollectingUseCase
import dev.plastikrab.weatherapp.domain.usecases.UpdateWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val startWeatherCollectingUseCase: StartWeatherCollectingUseCase,
    private val updateWeatherUseCase: UpdateWeatherUseCase
) : ViewModel() {

    private val _weather = MutableStateFlow<ResponseState<DomainWeather>>(ResponseState.Loading())
    val weather: StateFlow<ResponseState<DomainWeather>> = _weather.asStateFlow()

    init {
        viewModelScope.launch {
            startWeatherCollectingUseCase().collect{
                Log.d(TAG, "viewModelScope: $it")
                _weather.emit(it)
            }
        }
        viewModelScope.launch {
            weather.collect {
                if (it is ResponseState.Success) {
                    Log.d(TAG, "weather collect: ${it.data}")
                }
                if (it is ResponseState.Error) {
                    Log.d(TAG, "weather collect: ${it.message}")
                }
                if (it is ResponseState.Loading) {
                    Log.d(TAG, "weather collect: Loading")
                }
            }
        }
    }

    fun getWeather() {
        viewModelScope.launch {
            updateWeatherUseCase.invoke()
        }
    }
}