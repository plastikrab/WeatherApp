package dev.plastikrab.weatherapp.data.api.dto.forecast

import dev.plastikrab.weatherapp.domain.entities.forecast.DomainForecast
import kotlinx.serialization.Serializable

@Serializable
data class ForecastDto(
    val city: City,
    val cod: String,
    val message: Double,
    val cnt: Int,
    val list: List<DailyWeather>
){
    fun mapToDomain(): DomainForecast {
        return DomainForecast(
            city = city.mapToDomain(),
            cod = cod,
            message = message,
            cnt = cnt,
            list = list.map { it.mapToDomain() }
        )
    }

}