package com.ahmedhnewa.composemultiplatform.core.presentation.image_storage

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

actual class ImageStorage(
    private val context: Context
) {
    actual suspend fun saveImage(bytes: ByteArray): String {
        return withContext(Dispatchers.IO) {
            val fileName = "${UUID.randomUUID()}.jpg"
            context.openFileOutput(fileName, Context.MODE_PRIVATE)
                .use { outputStream ->
                    outputStream.write(bytes)
                }
            fileName
        }
    }

    actual suspend fun getImage(fileName: String): ByteArray? {
        return withContext(Dispatchers.IO) {
            context.openFileInput(fileName).use { inputStream ->
                inputStream.readBytes()
            }
        }
    }

    actual suspend fun deleteImage(fileName: String): Boolean {
        return withContext(Dispatchers.IO) {
            context.deleteFile(fileName)
        }
    }
}