package dev.plastikrab.weatherapp.data.api.dto.forecast

import dev.plastikrab.weatherapp.domain.entities.forecast.DomainCoord
import kotlinx.serialization.Serializable

@Serializable
data class Coord(
    val lon: Double,
    val lat: Double
){
    fun mapToDomain(): DomainCoord {
        return DomainCoord(
            lon = lon,
            lat = lat
        )
    }
}