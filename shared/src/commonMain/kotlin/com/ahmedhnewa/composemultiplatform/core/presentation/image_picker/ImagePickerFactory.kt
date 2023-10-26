package com.ahmedhnewa.composemultiplatform.core.presentation.image_picker

import androidx.compose.runtime.Composable

expect class ImagePickerFactory {

    @Composable
    fun createPicker(): ImagePicker
}