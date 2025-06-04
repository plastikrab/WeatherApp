package dev.plastikrab.weatherapp.domain.repositories

import dev.plastikrab.weatherapp.domain.entities.deviceData.Location


interface ILocationRepository {
    fun getCurrentLocation(): Location
}