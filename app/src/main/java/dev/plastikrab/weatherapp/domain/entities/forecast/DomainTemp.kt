package dev.plastikrab.weatherapp.domain.entities.forecast

data class DomainTemp(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)