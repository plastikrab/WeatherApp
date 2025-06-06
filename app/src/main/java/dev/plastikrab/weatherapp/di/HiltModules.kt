package dev.plastikrab.weatherapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.plastikrab.weatherapp.data.api.WeatherRepositoryImpl
import dev.plastikrab.weatherapp.data.device.location.LocationRepositoryImpl
import dev.plastikrab.weatherapp.domain.repositories.ILocationRepository
import dev.plastikrab.weatherapp.domain.repositories.IWeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HiltModules {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): IWeatherRepository

    @Binds
    @Singleton
    abstract fun bindLocationRepository(locationRepositoryImpl: LocationRepositoryImpl): ILocationRepository

}