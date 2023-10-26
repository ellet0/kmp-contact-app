package com.ahmedhnewa.composemultiplatform.di

import com.ahmedhnewa.composemultiplatform.contacts.data.SqlDelightContactDataSource
import com.ahmedhnewa.composemultiplatform.contacts.domain.ContactDataSource
import com.ahmedhnewa.composemultiplatform.core.data.DatabaseDriverFactory
import com.ahmedhnewa.composemultiplatform.core.presentation.image_storage.ImageStorage
import com.ahmedhnewa.composemultiplatform.database.ContactDatabase

actual class AppModule {
    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory().create()
            ),
            imageStorage = ImageStorage()
        )
    }
}