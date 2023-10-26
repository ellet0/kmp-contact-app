package com.ahmedhnewa.composemultiplatform.core.presentation.image_storage

expect class ImageStorage {
    suspend fun saveImage(bytes: ByteArray): String
    suspend fun getImage(fileName: String): ByteArray?
    suspend fun deleteImage(fileName: String): Boolean
}