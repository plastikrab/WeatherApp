package dev.plastikrab.weatherapp.domain.entities.weatherData

data class DomainWeatherDetail(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)