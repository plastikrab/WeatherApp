package dev.plastikrab.weatherapp.presentation.view.composables.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.plastikrab.weatherapp.TAG
import dev.plastikrab.weatherapp.domain.entities.forecast.DomainDailyWeather
import dev.plastikrab.weatherapp.utils.DateConverter

@Composable
fun ForecastItem(
    modifier: Modifier = Modifier,
    forecast: DomainDailyWeather
) {
    val dateConverter = DateConverter(unixTimestamp = forecast.dt)
    val dayTemp = forecast.temp.day.minus(273.15).toInt()
    val nightTemp = forecast.temp.night.minus(273.15).toInt()
    val clouds = forecast.weather.firstOrNull()?.description ?: "N/A"

    Log.d(TAG, "ForecastItem: ${forecast.dt}")

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = dateConverter.getDayOfWeek(),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = dateConverter.getDateTime(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "$dayTemp°C / $nightTemp°C",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(6.dp))


            Text(
                text = clouds.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface

            )
        }
    }
}