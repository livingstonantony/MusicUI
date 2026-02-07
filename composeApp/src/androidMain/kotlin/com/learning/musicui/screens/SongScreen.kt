package com.learning.musicui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.learning.musicui.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongScreen(modifier: Modifier = Modifier, back: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Now Playing",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Jetpack",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(color = Color(0xFF009688))
                                .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp)

                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        back()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Menu",
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Menu",
                        )
                    }
                }
            )
        }

    ) { paddingValues ->

        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .safeContentPadding()
                .fillMaxSize()

                .padding(paddingValues),

            ) {
            Column(
                modifier = modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Box(
                    modifier = Modifier
                        .size(300.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center

                ) {
                    Image(
                        contentDescription = "Network image description",
                        painter = painterResource(R.drawable.bar),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary),
                        modifier = Modifier
                            .size(220.dp)


                    )
                }

                Spacer(
                    Modifier.height(20.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
                        Text(
                            "The Striving", style = MaterialTheme.typography.titleLarge.copy(
                            )
                        )
                        Text(
                            "Aadesh Chouhan",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.DarkGray
                            ),
                        )
                    }

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer)

                    )
                }

                Spacer(modifier = Modifier.height(26.dp))

                SongProgressView(5.00f)

            }
        }
    }
}


@Preview
@Composable
fun SongScreenPreview() {
    MaterialTheme() {
        SongScreen() {

        }
    }
}