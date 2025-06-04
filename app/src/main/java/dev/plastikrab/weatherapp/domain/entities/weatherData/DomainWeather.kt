package dev.plastikrab.weatherapp.domain.entities.weatherData

data class DomainWeather(
    val coord: DomainCoord,
    val weather: List<DomainWeatherDetail>,
    val base: String,
    val main: DomainMainStats,
    val visibility: Int,
    val wind: DomainWind,
    val clouds: DomainClouds,
    val dt: Long,
    val sys: DomainSys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
)