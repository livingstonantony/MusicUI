package com.learning.musicui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.learning.musicui.screens.LoginScreen
import com.learning.musicui.screens.PlayListScreen
import com.learning.musicui.screens.PlayListScreenPreview
import com.learning.musicui.screens.SongScreen
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            NavApp()
        }
    }
}

@Serializable
data object LoginScreenKey : NavKey

@Serializable
data object PlayListScreenKey : NavKey

@Serializable
data class SongScreenKey(private val id: String) : NavKey


@Composable
fun NavApp() {
    val backStack = rememberNavBackStack(LoginScreenKey)

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLastOrNull()
            }
        },
        entryProvider = entryProvider {
            entry<LoginScreenKey> {
                LoginScreen() {
                    backStack.add(PlayListScreenKey)
                }
            }
            entry<PlayListScreenKey> {
                PlayListScreen() {
                    backStack.add(SongScreenKey(it))
                }
            }

            entry<SongScreenKey> {
                SongScreen() {
                    if (backStack.size > 1) {
                        backStack.removeLastOrNull()
                    }
                }
            }

        }
    )
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}