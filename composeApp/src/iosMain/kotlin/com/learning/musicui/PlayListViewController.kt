package com.learning.musicui

import androidx.compose.ui.window.ComposeUIViewController
import com.learning.musicui.screens.PlayListScreen

fun PlayListViewController(onSongSelect: () -> Unit) = ComposeUIViewController {
    PlayListScreen {
        onSongSelect() // call the Swift callback when a song is selected
    }
}