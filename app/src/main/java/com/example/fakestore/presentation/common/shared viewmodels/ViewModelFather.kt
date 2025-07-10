package com.example.fakestore.presentation.common.shared

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber

enum class State{
    INFO,
    SUCCESS,
    ERROR
}

data class Alert(
    val message: String,
    val state: State
)


