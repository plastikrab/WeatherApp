package dev.plastikrab.weatherapp.domain.entities.forecast

data class DomainDailyWeather(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: DomainTemp,
    val feels_like: DomainFeelsLike,
    val pressure: Int,
    val humidity: Int,
    val weather: List<DomainWeatherDescription>,
    val speed: Double,
    val deg: Int,
    val gust: Double,
    val clouds: Int,
    val pop: Double,
    val rain: Double? = null
)