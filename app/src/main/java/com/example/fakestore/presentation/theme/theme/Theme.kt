package com.example.fakestore.presentation.theme.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.example.fakestore.presentation.theme.color.backgroundDark
import com.example.fakestore.presentation.theme.color.backgroundLight
import com.example.fakestore.presentation.theme.color.errorContainerDark
import com.example.fakestore.presentation.theme.color.errorContainerLight
import com.example.fakestore.presentation.theme.color.errorDark
import com.example.fakestore.presentation.theme.color.errorLight
import com.example.fakestore.presentation.theme.color.inverseOnSurfaceDark
import com.example.fakestore.presentation.theme.color.inverseOnSurfaceLight
import com.example.fakestore.presentation.theme.color.inversePrimaryDark
import com.example.fakestore.presentation.theme.color.inversePrimaryLight
import com.example.fakestore.presentation.theme.color.inverseSurfaceDark
import com.example.fakestore.presentation.theme.color.inverseSurfaceLight
import com.example.fakestore.presentation.theme.color.onBackgroundDark
import com.example.fakestore.presentation.theme.color.onBackgroundLight
import com.example.fakestore.presentation.theme.color.onErrorContainerDark
import com.example.fakestore.presentation.theme.color.onErrorContainerLight
import com.example.fakestore.presentation.theme.color.onErrorDark
import com.example.fakestore.presentation.theme.color.onErrorLight
import com.example.fakestore.presentation.theme.color.onPrimaryContainerDark
import com.example.fakestore.presentation.theme.color.onPrimaryContainerLight
import com.example.fakestore.presentation.theme.color.onPrimaryDark
import com.example.fakestore.presentation.theme.color.onPrimaryLight
import com.example.fakestore.presentation.theme.color.onSecondaryContainerDark
import com.example.fakestore.presentation.theme.color.onSecondaryContainerLight
import com.example.fakestore.presentation.theme.color.onSecondaryDark
import com.example.fakestore.presentation.theme.color.onSecondaryLight
import com.example.fakestore.presentation.theme.color.onSurfaceDark
import com.example.fakestore.presentation.theme.color.onSurfaceLight
import com.example.fakestore.presentation.theme.color.onSurfaceVariantDark
import com.example.fakestore.presentation.theme.color.onSurfaceVariantLight
import com.example.fakestore.presentation.theme.color.onTertiaryContainerDark
import com.example.fakestore.presentation.theme.color.onTertiaryContainerLight
import com.example.fakestore.presentation.theme.color.onTertiaryDark
import com.example.fakestore.presentation.theme.color.onTertiaryLight
import com.example.fakestore.presentation.theme.color.outlineDark
import com.example.fakestore.presentation.theme.color.outlineLight
import com.example.fakestore.presentation.theme.color.outlineVariantDark
import com.example.fakestore.presentation.theme.color.outlineVariantLight
import com.example.fakestore.presentation.theme.color.primaryContainerDark
import com.example.fakestore.presentation.theme.color.primaryContainerLight
import com.example.fakestore.presentation.theme.color.primaryDark
import com.example.fakestore.presentation.theme.color.primaryLight
import com.example.fakestore.presentation.theme.color.scrimDark
import com.example.fakestore.presentation.theme.color.scrimLight
import com.example.fakestore.presentation.theme.color.secondaryContainerDark
import com.example.fakestore.presentation.theme.color.secondaryContainerLight
import com.example.fakestore.presentation.theme.color.secondaryDark
import com.example.fakestore.presentation.theme.color.secondaryLight
import com.example.fakestore.presentation.theme.color.surfaceBrightDark
import com.example.fakestore.presentation.theme.color.surfaceBrightLight
import com.example.fakestore.presentation.theme.color.surfaceContainerDark
import com.example.fakestore.presentation.theme.color.surfaceContainerHighDark
import com.example.fakestore.presentation.theme.color.surfaceContainerHighLight
import com.example.fakestore.presentation.theme.color.surfaceContainerHighestDark
import com.example.fakestore.presentation.theme.color.surfaceContainerHighestLight
import com.example.fakestore.presentation.theme.color.surfaceContainerLight
import com.example.fakestore.presentation.theme.color.surfaceContainerLowDark
import com.example.fakestore.presentation.theme.color.surfaceContainerLowLight
import com.example.fakestore.presentation.theme.color.surfaceContainerLowestDark
import com.example.fakestore.presentation.theme.color.surfaceContainerLowestLight
import com.example.fakestore.presentation.theme.color.surfaceDark
import com.example.fakestore.presentation.theme.color.surfaceDimDark
import com.example.fakestore.presentation.theme.color.surfaceDimLight
import com.example.fakestore.presentation.theme.color.surfaceLight
import com.example.fakestore.presentation.theme.color.surfaceVariantDark
import com.example.fakestore.presentation.theme.color.surfaceVariantLight
import com.example.fakestore.presentation.theme.color.tertiaryContainerDark
import com.example.fakestore.presentation.theme.color.tertiaryContainerLight
import com.example.fakestore.presentation.theme.color.tertiaryDark
import com.example.fakestore.presentation.theme.color.tertiaryLight
import com.example.fakestore.presentation.theme.type.AppTypography

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) darkScheme else lightScheme
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

