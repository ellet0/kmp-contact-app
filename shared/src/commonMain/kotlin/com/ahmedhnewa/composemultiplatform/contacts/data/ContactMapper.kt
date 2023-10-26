package com.ahmedhnewa.composemultiplatform.contacts.data

import com.ahmedhnewa.composemultiplatform.contacts.domain.Contact
import com.ahmedhnewa.composemultiplatform.core.presentation.image_storage.ImageStorage
import database.ContactEntity

suspend fun ContactEntity.toContact(imageStorage: ImageStorage) = Contact(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    phoneNumber = phoneNumber,
    photoBytes = imagePath?.let {
        imageStorage.getImage(it)
    }
)