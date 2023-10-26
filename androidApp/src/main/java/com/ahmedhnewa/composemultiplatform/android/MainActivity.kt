package com.ahmedhnewa.composemultiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.ahmedhnewa.composemultiplatform.App
import com.ahmedhnewa.composemultiplatform.core.presentation.image_picker.ImagePickerFactory
import com.ahmedhnewa.composemultiplatform.di.AppModule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                useDarkTheme = isSystemInDarkTheme(),
                useDynamicColor = true,
                appModule = AppModule(LocalContext.current.applicationContext),
                imagePicker = ImagePickerFactory().createPicker()
            )
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    GreetingView(Greeting().greet())
//                }
//            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    App(
        useDarkTheme = true,
        useDynamicColor = true,
        appModule = AppModule(LocalContext.current.applicationContext),
        imagePicker = ImagePickerFactory().createPicker()
    )
}
