package dev.plastikrab.weatherapp.domain.entities.forecast

data class DomainCity(
    val id: Int,
    val name: String,
    val coord: DomainCoord,
    val country: String,
    val population: Int,
    val timezone: Int
)
