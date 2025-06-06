package dev.plastikrab.weatherapp.data.api.dto.weather

import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainSys

data class SysDto(
    val sunrise: Long,
    val sunset: Long
){
    fun mapToDomain() : DomainSys{
        return DomainSys(
            sunrise = sunrise,
            sunset = sunset
        )
    }
}