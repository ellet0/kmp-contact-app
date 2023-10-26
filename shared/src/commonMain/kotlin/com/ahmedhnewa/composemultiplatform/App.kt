package com.ahmedhnewa.composemultiplatform

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ahmedhnewa.composemultiplatform.contacts.presentation.ContactListViewModel
import com.ahmedhnewa.composemultiplatform.contacts.presentation.componenets.ContactListScreen
import com.ahmedhnewa.composemultiplatform.core.presentation.image_picker.ImagePicker
import com.ahmedhnewa.composemultiplatform.di.AppModule
import com.ahmedhnewa.composemultiplatform.ui.theme.AppTheme
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    useDarkTheme: Boolean,
    useDynamicColor: Boolean,
    appModule: AppModule,
    imagePicker: ImagePicker
) {
    AppTheme(
        useDarkTheme = useDarkTheme,
        useDynamicColors = useDynamicColor
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val viewModel = getViewModel(
                key = "contactListScreen",
                factory = viewModelFactory {
                    ContactListViewModel(appModule.contactDataSource)
                }
            )
            val state by viewModel.state.collectAsState()
            ContactListScreen(
                state = state,
                newContact = viewModel.newContact,
                onEvent = viewModel::onEvent,
                imagePicker = imagePicker
            )
        }
    }
}