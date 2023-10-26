package com.ahmedhnewa.composemultiplatform.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun AppTheme(
    useDarkTheme: Boolean,
    useDynamicColors: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (!useDarkTheme) {
        LightColorScheme
    } else {
        DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}