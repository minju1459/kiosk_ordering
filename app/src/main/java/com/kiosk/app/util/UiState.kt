package com.kiosk.app.util

sealed class UiState {
    object Success : UiState()
    data class Failure(val code: Int?) : UiState()
    object Error : UiState()
}
