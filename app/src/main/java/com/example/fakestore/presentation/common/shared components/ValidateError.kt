package com.example.fakestore.presentation.common.shared

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ValidateError(modifier: Modifier = Modifier, error: String?) {
    AnimatedVisibility(
        visible = error != null,
        enter =
            slideInVertically(
                initialOffsetY = { fullHeight -> -fullHeight }
            ) + fadeIn(),
        exit =
            slideOutVertically(
                targetOffsetY = { fullHeight -> fullHeight }
            ) + fadeOut()
    ) {
        Text(
            modifier = modifier,
            text = error.orEmpty(),
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

