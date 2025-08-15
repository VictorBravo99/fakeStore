package com.example.fakestore.presentation.common.sharedComponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged

@Composable
@Stable
fun Modifier.validateOffFocus(
    onValidate: () -> Unit,
): Modifier {
    var emailHasLostFocus by remember { mutableStateOf(false) }
    return onFocusChanged { focusState ->
        if (!focusState.isFocused && emailHasLostFocus) onValidate()

        if (!focusState.isFocused) emailHasLostFocus = true
    }

}

