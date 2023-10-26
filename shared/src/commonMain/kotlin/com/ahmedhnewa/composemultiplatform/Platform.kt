package com.ahmedhnewa.composemultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform