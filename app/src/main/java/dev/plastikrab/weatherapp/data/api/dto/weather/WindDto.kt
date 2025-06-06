package dev.plastikrab.weatherapp.data.api.dto.weather

import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainWind

data class WindDto(
    val speed: Double,
    val deg: Int,
    val gust: Double?
){
    fun mapToDomain(): DomainWind{
        return DomainWind(
            speed = speed,
            deg = deg,
            gust = gust
        )
    }
}