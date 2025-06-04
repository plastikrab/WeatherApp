package dev.plastikrab.weatherapp.domain.states

sealed interface ResponseState<T> {
    class Success<T>(val data: T) : ResponseState<T>
    class Loading<T> : ResponseState<T>
    class Error<T>(val message: String) : ResponseState<T>

}