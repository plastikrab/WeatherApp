package dev.plastikrab.weatherapp.data.api.dto.forecast

import dev.plastikrab.weatherapp.domain.entities.forecast.DomainWeatherDescription
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDescription(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
){
    fun mapToDomain(): DomainWeatherDescription {
        return DomainWeatherDescription(
            id = id,
            main = main,
            description = description,
            icon = icon
        )
    }
}