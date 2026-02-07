package com.learning.musicui.utils

import kotlin.math.pow
import kotlin.math.roundToInt


// Source - https://stackoverflow.com/a/63670681
// Posted by Bogdan Draghici
// Retrieved 2026-01-28, License - CC BY-SA 4.0

import kotlin.math.roundToInt

fun Float.roundToDecimals(decimals: Int): Float {
    val factor = 10f.pow(decimals)
    return (this * factor).roundToInt() / factor
}

