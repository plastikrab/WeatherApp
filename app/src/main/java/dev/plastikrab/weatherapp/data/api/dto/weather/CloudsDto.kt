package dev.plastikrab.weatherapp.data.api.dto.weather

import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainClouds


data class CloudsDto(
    val all: Int
){
    fun mapToDomain(): DomainClouds{
        return DomainClouds(
            all = all
        )
    }
}
