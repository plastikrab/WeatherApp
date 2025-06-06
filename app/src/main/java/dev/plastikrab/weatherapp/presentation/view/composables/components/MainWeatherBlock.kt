package dev.plastikrab.weatherapp.presentation.view.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.plastikrab.weatherapp.domain.entities.weatherData.DomainWeather

@Composable
fun MainWeatherBlock(
    modifier: Modifier = Modifier,
    weather: DomainWeather?,
) {
    val name = weather?.name
    val temp = weather?.main?.temp?.minus(273.15)?.toInt()
    val wind = weather?.wind?.speed
    val clouds = weather?.weather[0]?.description

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name.toString(),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$temp°C",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = clouds.toString().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Wind Speed $wind m/s",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}