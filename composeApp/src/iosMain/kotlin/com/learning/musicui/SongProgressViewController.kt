package com.learning.musicui

import androidx.compose.ui.window.ComposeUIViewController
import com.learning.musicui.screens.SongProgressView

fun SongProgressViewController() = ComposeUIViewController { SongProgressView(5.00f) }