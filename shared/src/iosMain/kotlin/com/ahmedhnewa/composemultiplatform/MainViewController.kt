package com.ahmedhnewa.composemultiplatform

import androidx.compose.ui.interop.LocalUIViewController
import androidx.compose.ui.window.ComposeUIViewController
import com.ahmedhnewa.composemultiplatform.core.presentation.image_picker.ImagePickerFactory
import com.ahmedhnewa.composemultiplatform.di.AppModule
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

fun isIosSystemInDarkTheme(): Boolean =
    UIScreen.mainScreen.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark

// No @Composable
fun MainViewController() = ComposeUIViewController {
    App(
        useDarkTheme = isIosSystemInDarkTheme(),
        useDynamicColor = false,
        appModule = AppModule(),
        imagePicker = ImagePickerFactory(
            rootController = LocalUIViewController.current
        ).createPicker()
    )
}