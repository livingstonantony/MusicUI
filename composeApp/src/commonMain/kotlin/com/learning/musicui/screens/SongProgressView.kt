package com.learning.musicui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learning.musicui.utils.roundToDecimals
import musicui.composeapp.generated.resources.Res
import musicui.composeapp.generated.resources.mobiledata
import org.jetbrains.compose.resources.painterResource

// Source - https://stackoverflow.com/a/42799606
// Posted by Ilya
// Retrieved 2026-01-27, License - CC BY-SA 3.0


val ICON_SIZE_MEDIUM = 34.dp
val ICON_SIZE_LARGE = 48.dp

@Composable
fun SongProgressView(songDuration: Float) {

    var currentProgress by remember { mutableStateOf(0f) } // 0f..1f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                1.dp, color = Color.LightGray)
            .padding(8.dp)
            ,
        contentAlignment = Alignment.TopEnd
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {


            Spacer(Modifier.height(35.dp))
            // 🎯 INTERACTIVE SEEK BAR
            SeekBar(
                progress = currentProgress,
                onProgressChange = { currentProgress = it },
                modifier = Modifier.fillMaxWidth(),
                songDuration = songDuration
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Time Labels
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("${currentProgress.roundToDecimals(2)}")
                Spacer(modifier = Modifier.weight(1f))
                Text("${(songDuration - currentProgress).roundToDecimals(2)}")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Controls
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Repeat,
                        contentDescription = "Loop",
                        modifier = Modifier.size(ICON_SIZE_MEDIUM),
                        tint = Color.DarkGray
                    )
                }

                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Replay10,
                        contentDescription = "Replay 10",
                        modifier = Modifier.size(ICON_SIZE_MEDIUM),
                        tint = Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {},
                    modifier = Modifier.size(72.dp)
                ) {
                    Icon(
                        Icons.Outlined.PlayCircleFilled,
                        contentDescription = "Play",
                        modifier = Modifier.size(ICON_SIZE_LARGE),
                        tint = Color.DarkGray
                    )
                }

                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Forward10,
                        contentDescription = "Forward 10",
                        modifier = Modifier.size(ICON_SIZE_MEDIUM),
                        tint = Color.DarkGray
                    )
                }

                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(Res.drawable.mobiledata),
                        contentDescription = "Options",
                        modifier = Modifier.size(ICON_SIZE_MEDIUM),
                        tint = Color.DarkGray
                    )
                }
            }

        }
        Text(
            text = "CMP",
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(color = Color(0xFF6494F6))
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)

        )
    }
}

@Composable
fun SeekBar(
    progress: Float,
    onProgressChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    songDuration: Float
) {
    Slider(
        value = progress,
        onValueChange = onProgressChange,
        valueRange = 0f..songDuration,
        modifier = modifier,
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.primary,
            activeTrackColor = MaterialTheme.colorScheme.primary,
            inactiveTrackColor = MaterialTheme.colorScheme.primaryContainer
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun SongProgressViewPreview() {
    MaterialTheme {
        Column {
            Spacer(Modifier.height(70.dp))
            SongProgressView(5.00f)
        }
    }
}
