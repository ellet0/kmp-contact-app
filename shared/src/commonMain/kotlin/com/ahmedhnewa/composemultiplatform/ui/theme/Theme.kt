package com.ahmedhnewa.composemultiplatform.ui.theme

import androidx.compose.runtime.Composable

@Composable
expect fun AppTheme(
    useDarkTheme: Boolean,
    useDynamicColors: Boolean,
    content: @Composable () -> Unit
)