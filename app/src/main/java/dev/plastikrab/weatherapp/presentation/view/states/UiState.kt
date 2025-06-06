package dev.plastikrab.weatherapp.presentation.view.states

sealed interface UiState {
    class Loading() : UiState
    class Error(): UiState
    class Success(): UiState
}