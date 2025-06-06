package dev.plastikrab.weatherapp.data.api.dto.forecast

import dev.plastikrab.weatherapp.domain.entities.forecast.DomainFeelsLike
import kotlinx.serialization.Serializable

@Serializable
data class FeelsLike(
    val day: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
){
    fun mapToDomain(): DomainFeelsLike {
        return DomainFeelsLike(
            day = day,
            night = night,
            eve = eve,
            morn = morn
        )
    }
}