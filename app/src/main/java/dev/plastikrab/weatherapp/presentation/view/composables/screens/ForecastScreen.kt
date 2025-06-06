package dev.plastikrab.weatherapp.presentation.view.composables.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.plastikrab.weatherapp.TAG
import dev.plastikrab.weatherapp.presentation.view.composables.components.ForecastItem
import dev.plastikrab.weatherapp.presentation.view.theme.backgroundColor
import dev.plastikrab.weatherapp.presentation.viewModel.MainViewModel

@Composable
fun ForecastScreen(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    Log.d(TAG, "ForecastScreen: $viewModel")
    val forecast by viewModel.weatherForecast.collectAsState()

    val uiState by viewModel.uiState.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        forecast?.let {
            Log.d(TAG, "ForecastScreen: forecast is not null")
            LazyRow {
                items(forecast!!.list) {
                    ForecastItem(forecast = it)
                }
            }
        }
        if (forecast == null) {
            Log.d(TAG, "ForecastScreen: forecast is null")
        }
    }
}