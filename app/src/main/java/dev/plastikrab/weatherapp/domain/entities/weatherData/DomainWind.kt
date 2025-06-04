package dev.plastikrab.weatherapp.domain.entities.weatherData

data class DomainWind(
    val speed: Double,
    val deg: Int,
    val gust: Double?
)