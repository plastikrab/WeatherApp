package dev.plastikrab.weatherapp.presentation.view.composables.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.plastikrab.weatherapp.presentation.viewModel.MainViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
    ) {

    Button(
        onClick = { viewModel.getWeather() }

    ) {
        Text(
            text = "Get Weather"
        )
    }
}