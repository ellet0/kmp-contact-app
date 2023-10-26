package com.ahmedhnewa.composemultiplatform.core.data

import com.ahmedhnewa.composemultiplatform.database.ContactDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory() {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(
            ContactDatabase.Schema,
            "contact.db"
        )
    }
}