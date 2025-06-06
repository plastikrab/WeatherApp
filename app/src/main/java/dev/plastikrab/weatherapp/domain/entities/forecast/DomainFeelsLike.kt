package dev.plastikrab.weatherapp.domain.entities.forecast

data class DomainFeelsLike(
    val day: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)