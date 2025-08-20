package com.example.simplefood2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform