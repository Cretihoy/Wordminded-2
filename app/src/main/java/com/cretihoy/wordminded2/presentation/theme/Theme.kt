package com.cretihoy.wordminded2.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

private val lightColorPalette = lightColorScheme(
    background = White,
    onBackground = Black,

    primary = LightBlue,
    onPrimary = White,
    primaryContainer = DarkBlue,

    onError = LightYellow,

    surface = DarkGray,
    onSurface = LightGray,

    secondary = LightRed,
    onSecondary = Black,
    secondaryContainer = DarkRed
)

private val darkColorPalette = darkColorScheme(
    background = Black,
    onBackground = White,

    primary = DarkBlue,
    onPrimary = Black,
    primaryContainer = LightBlue,

    onError = DarkYellow,

    surface = LightGray,
    onSurface = DarkGray,

    secondary = DarkRed,
    onSecondary = White,
    secondaryContainer = LightRed
)

@Composable
fun Wordminded2Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val viewModel = hiltViewModel<ThemeViewModel>()

    val altTheme = if (viewModel.isAltTheme.value) {
        !darkTheme
    } else {
        darkTheme
    }

    val colors = if (altTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}