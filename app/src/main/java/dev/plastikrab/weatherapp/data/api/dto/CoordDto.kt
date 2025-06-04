package dev.plastikrab.weatherapp.data.api.dto

import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainCoord

data class CoordDto(
    val lon: Double,
    val lat: Double
){
    fun mapToDomain(): DomainCoord{
        return DomainCoord(
            lon = lon,
            lat = lat
        )
    }
}