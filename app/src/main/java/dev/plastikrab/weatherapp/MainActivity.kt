package dev.plastikrab.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import dev.plastikrab.weatherapp.presentation.view.composables.screens.MainScreen
import dev.plastikrab.weatherapp.presentation.view.theme.WeatherAppTheme
import dev.plastikrab.weatherapp.utils.PermissionsManager

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val permissionsManager = PermissionsManager(this)
        permissionsManager.checkPermissions()
        setContent {
            WeatherAppTheme {
                MainScreen()
            }
        }
    }
}
