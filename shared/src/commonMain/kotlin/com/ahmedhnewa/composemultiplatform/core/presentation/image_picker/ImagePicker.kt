package com.ahmedhnewa.composemultiplatform.core.presentation.image_picker

import androidx.compose.runtime.Composable

expect class ImagePicker {
    @Composable
    fun registerPicker(onImagePicked: (ByteArray) -> Unit)

    fun pickImage()
}