package dev.plastikrab.weatherapp.data.api.dto.weather

import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainWeather

data class WeatherDto(
    val coord: CoordDto,
    val weather: List<WeatherDetailDto>,
    val base: String,
    val main: MainStatsDto,
    val visibility: Int,
    val wind: WindDto,
    val clouds: CloudsDto,
    val dt: Long,
    val sys: SysDto,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
){
    fun mapToDomain(): DomainWeather{
        return DomainWeather(
            coord = coord.mapToDomain(),
            weather = weather.map { it.mapToDomain() },
            base = base,
            main = main.mapToDomain(),
            visibility = visibility,
            wind = wind.mapToDomain(),
            clouds = clouds.mapToDomain(),
            dt = dt,
            sys = sys.mapToDomain(),
            timezone = timezone,
            id = id,
            name = name,
            cod = cod
        )
    }
}