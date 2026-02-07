package com.learning.musicui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform