package dev.plastikrab.weatherapp.data.api.dto.forecast

import dev.plastikrab.weatherapp.domain.entities.forecast.DomainDailyWeather
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeather(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: Temp,
    val feels_like: FeelsLike,
    val pressure: Int,
    val humidity: Int,
    val weather: List<WeatherDescription>,
    val speed: Double,
    val deg: Int,
    val gust: Double,
    val clouds: Int,
    val pop: Double,
    val rain: Double? = null
){
    fun mapToDomain(): DomainDailyWeather{
        return DomainDailyWeather(
            dt = dt,
            sunrise = sunrise,
            sunset = sunset,
            temp = temp.mapToDomain(),
            feels_like = feels_like.mapToDomain(),
            pressure = pressure,
            humidity = humidity,
            weather = weather.map { it.mapToDomain() },
            speed = speed,
            deg = deg,
            gust = gust,
            clouds = clouds,
            pop = pop,
            rain = rain
        )
    }
}