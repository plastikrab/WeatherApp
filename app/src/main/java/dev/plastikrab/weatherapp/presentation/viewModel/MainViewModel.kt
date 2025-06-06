package dev.plastikrab.weatherapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.plastikrab.weatherapp.TAG
import dev.plastikrab.weatherapp.domain.entities.forecast.DomainForecast
import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainWeather
import dev.plastikrab.weatherapp.domain.states.ResponseState
import dev.plastikrab.weatherapp.domain.usecases.GetForecastUseCase
import dev.plastikrab.weatherapp.domain.usecases.SetUpdaterUseCase
import dev.plastikrab.weatherapp.domain.usecases.StartWeatherCollectingUseCase
import dev.plastikrab.weatherapp.domain.usecases.UpdateWeatherUseCase
import dev.plastikrab.weatherapp.presentation.view.states.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel()
class MainViewModel @Inject constructor(
    private val startWeatherCollectingUseCase: StartWeatherCollectingUseCase,
    private val updateWeatherUseCase: UpdateWeatherUseCase,
    private val getForecastUseCase: GetForecastUseCase,
    private val setUpdaterUseCase: SetUpdaterUseCase
) : ViewModel() {

    private val _todayWeather = MutableStateFlow<DomainWeather?>(null)
    val todayWeather: StateFlow<DomainWeather?> = _todayWeather.asStateFlow()

    private val _weatherForecast = MutableStateFlow<DomainForecast?>(null)
    val weatherForecast: StateFlow<DomainForecast?> = _weatherForecast.asStateFlow()

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            startWeatherCollectingUseCase().collect{
                if (it is ResponseState.Success) {
                    _uiState.emit(UiState.Success())
                    Log.d(TAG, "weather collect: Success")
                    _todayWeather.emit(it.data)
                }
                if (it is ResponseState.Error) {
                    _uiState.emit(UiState.Error())
                    Log.d(TAG, "weather collect: ${it.message}")
                }
                if (it is ResponseState.Loading) {
                    _uiState.emit(UiState.Loading())
                    Log.d(TAG, "weather collect: Loading")
                }
            }
            setUpdaterUseCase()
        }
    }

    fun updateWeather() {
        viewModelScope.launch {
            updateWeatherUseCase.invoke()
        }
    }

    fun getForecast() {
        viewModelScope.launch {
            val forecast = getForecastUseCase.invoke()
            if (forecast is ResponseState.Success) {
                _uiState.emit(UiState.Success())
                _weatherForecast.emit(forecast.data)
            }
            if (forecast is ResponseState.Error) {
                _uiState.emit(UiState.Error())
                Log.d(TAG, "getForecast: ${forecast.message}")
            }
            if (forecast is ResponseState.Loading) {
                _uiState.emit(UiState.Loading())
                Log.d(TAG, "getForecast: Loading")
            }
        }
    }


}