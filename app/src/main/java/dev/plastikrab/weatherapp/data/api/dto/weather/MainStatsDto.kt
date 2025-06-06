package dev.plastikrab.weatherapp.data.api.dto.weather

import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainMainStats

data class MainStatsDto(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int,
    val sea_level: Int?,
    val grnd_level: Int?
){
    fun mapToDomain(): DomainMainStats{
        return DomainMainStats(
            temp = temp,
            feelsLike = feels_like,
            tempMin = temp_min,
            tempMax = temp_max,
            pressure = pressure,
            humidity = humidity,
            seaLevel = sea_level,
            grndLevel = grnd_level
        )
    }
}