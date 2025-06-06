package dev.plastikrab.weatherapp.domain.entities.forecast



data class DomainForecast(
    val city: DomainCity,
    val cod: String,
    val message: Double,
    val cnt: Int,
    val list: List<DomainDailyWeather>
)