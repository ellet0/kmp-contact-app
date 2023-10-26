package com.ahmedhnewa.composemultiplatform.di

import com.ahmedhnewa.composemultiplatform.contacts.domain.ContactDataSource

expect class AppModule {
    val contactDataSource: ContactDataSource
}