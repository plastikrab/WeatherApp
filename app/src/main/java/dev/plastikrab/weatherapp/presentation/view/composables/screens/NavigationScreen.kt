package dev.plastikrab.weatherapp.presentation.view.composables.screens

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.plastikrab.weatherapp.Screens
import dev.plastikrab.weatherapp.presentation.viewModel.MainViewModel

@Composable
fun NavigationScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {


    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.MAIN_SCREEN,
        exitTransition = {
            fadeOut(animationSpec = tween(0))
        },
        enterTransition = {
            fadeIn(animationSpec = tween(0))
        }
    ) {
        composable(Screens.MAIN_SCREEN) {
            MainScreen(navController, viewModel = viewModel)
        }
        composable(Screens.FORECAST_SCREEN) {
            ForecastScreen(navController, viewModel = viewModel)
        }
    }
}

