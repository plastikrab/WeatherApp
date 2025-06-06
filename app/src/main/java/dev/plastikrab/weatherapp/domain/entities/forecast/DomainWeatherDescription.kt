package dev.plastikrab.weatherapp.domain.entities.forecast

data class DomainWeatherDescription(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)