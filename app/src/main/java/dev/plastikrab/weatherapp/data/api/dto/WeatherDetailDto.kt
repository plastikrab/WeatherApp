package dev.plastikrab.weatherapp.data.api.dto

import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainWeatherDetail

data class WeatherDetailDto(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
) {
    fun mapToDomain(): DomainWeatherDetail {
        return DomainWeatherDetail(
            id = id,
            main = main,
            description = description,
            icon = icon
        )
    }
}