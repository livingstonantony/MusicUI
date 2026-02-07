package com.learning.musicui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.learning.musicui.R

val URL =
    "https://hips.hearstapps.com/hmg-prod/images/summer-flowers-1648478322.jpg?crop=0.668xw:1.00xh;0.298xw,0&resize=980:*"

@Composable
fun LoginScreen(modifier: Modifier = Modifier, login: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding(),
        contentAlignment = Alignment.TopEnd
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()

        ) {

            Column(
                modifier = modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.music_cast_24px),
                    contentDescription = "Network image description",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .size(300.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(40.dp)

                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Listen to the best podcast",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Literally it does not mean anything." +
                            "\nit is sequence",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.Center
                    ),
                )
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { login.invoke() },
                    modifier = modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1C1C1C)
                    )
                ) {
                    Text("Login")
                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedButton(
                    onClick = {},
                    modifier = modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, Color(0xFF1C1C1C))
                ) {
                    Text(
                        "Signup",
                        color = Color(0xFF1C1C1C)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
            }

        }
        Text(
            text = "Jetpack",
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = Color(0xFF009688))
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)

        )
    }

}

@Preview
@Composable
fun LoginScreenPreview() {

    MaterialTheme() {
        Scaffold() { _ ->
            LoginScreen(modifier = Modifier) {

            }
        }

    }
}