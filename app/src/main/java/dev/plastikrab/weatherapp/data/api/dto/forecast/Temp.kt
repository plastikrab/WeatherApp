package dev.plastikrab.weatherapp.data.api.dto.forecast

import dev.plastikrab.weatherapp.domain.entities.forecast.DomainTemp
import kotlinx.serialization.Serializable

@Serializable
data class Temp(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
){
    fun mapToDomain(): DomainTemp {
        return DomainTemp(
            day = day,
            min = min,
            max = max,
            night = night,
            eve = eve,
            morn = morn
        )
    }
}