package dev.plastikrab.weatherapp.presentation.view.composables.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.plastikrab.weatherapp.Screens
import dev.plastikrab.weatherapp.TAG
import dev.plastikrab.weatherapp.presentation.view.composables.components.MainWeatherBlock
import dev.plastikrab.weatherapp.presentation.view.states.UiState
import dev.plastikrab.weatherapp.presentation.view.theme.backgroundColor
import dev.plastikrab.weatherapp.presentation.viewModel.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    Log.d(TAG, "ForecastScreen: $viewModel")
    val todayWeather by viewModel.todayWeather.collectAsState()

    val uiState by viewModel.uiState.collectAsState()

    val pullToRefreshState = rememberPullToRefreshState()

    var isRefreshing by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    PullToRefreshBox(
        state = pullToRefreshState,
        isRefreshing = isRefreshing,
        onRefresh = {
            scope.launch {
                Log.d(TAG, "MainScreen: pull to refresh triggrered")
                isRefreshing = true
                Log.d("PullToRefreshDebug", "isRefreshing set to true")
                try {
                    viewModel.updateWeather()
                    delay(200)
                } finally {
                    isRefreshing = false
                    Log.d("PullToRefreshDebug", "isRefreshing set to false")
                }
            }
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (uiState) {
                is UiState.Success -> {

                    MainWeatherBlock(
                        weather = todayWeather
                    )
                    Button(onClick = {
                        viewModel.getForecast()
                        navController.navigate(Screens.FORECAST_SCREEN)
                    }
                    ) {
                        Text(text = "Week Forecast")
                    }
                }

                is UiState.Error -> {

                }

                is UiState.Loading -> {

                }
            }
        }
    }

    LaunchedEffect(true) {
        viewModel.updateWeather()
    }
}