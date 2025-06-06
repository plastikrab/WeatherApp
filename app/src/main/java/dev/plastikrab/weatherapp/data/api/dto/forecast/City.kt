package dev.plastikrab.weatherapp.data.api.dto.forecast

import dev.plastikrab.weatherapp.domain.entities.forecast.DomainCity
import kotlinx.serialization.Serializable

@Serializable
data class City(
    val id: Int,
    val name: String,
    val coord: Coord,
    val country: String,
    val population: Int,
    val timezone: Int
){
    fun mapToDomain(): DomainCity {
        return DomainCity(
            id = id,
            name = name,
            coord = coord.mapToDomain(),
            country = country,
            population = population,
            timezone = timezone
        )
    }
}
