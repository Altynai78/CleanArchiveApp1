package com.example.cleanarchiveapp1.presentation.utlis


sealed class UiState<T> {

    class Loading<T> : UiState<T>()
    class Success<T>(val data: T) : UiState<T>()
    class Error<T>(val message: String) : UiState<T>()
    class EmptyState<T> : UiState<T>()
}