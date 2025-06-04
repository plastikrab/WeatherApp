package dev.plastikrab.weatherapp.domain.entities.weatherData

data class DomainMainStats(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
    val seaLevel: Int?,
    val grndLevel: Int?
)