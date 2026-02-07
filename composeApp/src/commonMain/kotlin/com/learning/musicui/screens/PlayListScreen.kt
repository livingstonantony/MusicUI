package com.learning.musicui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
fun generateRandomId(): String {
    val randomUuid = Uuid.random()
    return randomUuid.toString()
}

data class Song(
    val title: String,
    val singer: String,
    val id: String = generateRandomId()
)

val songs = listOf<Song>(
    Song("The Striving", "Aadesh Chauhan"),
    Song("Life is more Youthful", "Neha Makwana"),
    Song("Happy Moments", "Janhvi Chauhan"),
    Song("Population", "Mihir Songara"),
    Song("Population", "Mihir Songara"),
    Song("Population", "Mihir Songara"),
    Song("Population", "Mihir Songara"),
    Song("Population", "Mihir Songara"),
    Song("Population", "Mihir Songara"),
    Song("Population", "Mihir Songara"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayListScreen(onClick: (String) -> Unit) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {

                    Text(
                        text = "CMP",
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(color = Color(0xFF6494F6))
                            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                    )

                },
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Default.Notes,
                            contentDescription = "Menu",
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Menu",
                        )
                    }
                }
            )
        }
    ) { paddingValues ->


        Column(
            modifier = Modifier.fillMaxSize()
                .padding(20.dp)
                .padding(paddingValues)

        ) {

            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 20.dp, bottom = 20.dp)
                        .clip(CircleShape)
                        .background(color = Color.White)
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.GraphicEq,
                            contentDescription = "Music",
                            modifier = Modifier
                                .size(35.dp)

                        )
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Trending Podcasts",
                    style = MaterialTheme.typography.titleLarge.copy(
                    )
                )
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Menu",

                        )
                }
            }


            LazyColumn(
            ) {
                items(songs.size) { index ->
                    SongItem(title = songs[index].title, singer = songs[index].singer, onClick)
                }

            }
        }


    }
}


@Composable
fun SongItem(title: String, singer: String, onClick: (String) -> Unit) {

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 8.dp)
            .clickable {
                onClick(title)
            },
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = MaterialTheme.colorScheme.primaryContainer)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = singer,
                style = MaterialTheme.typography.bodySmall.copy(
                )
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.PlayCircleFilled,
                contentDescription = "Play",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(60.dp)
            )
        }
    }
}


@Preview
@Composable
fun PlayListScreenPreview() {
    MaterialTheme {
        PlayListScreen() {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SongItemPreview() {
    MaterialTheme {
        SongItem("The Striving", "Aadesh Chauhan", onClick = {})

    }
}