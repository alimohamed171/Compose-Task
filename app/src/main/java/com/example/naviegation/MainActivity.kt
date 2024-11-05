package com.example.naviegation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.naviegation.ui.screens.NavHostScreen
import com.example.naviegation.ui.theme.Black
import com.example.naviegation.ui.theme.Green
import com.example.naviegation.ui.theme.NaviegationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showWelcomeScreen by remember { mutableStateOf(true) }

            NaviegationTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    NavHostScreen()

                    // Overlay for the welcome screen
                    if (showWelcomeScreen) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background( Black.copy(alpha = 0.8f))
                                .clickable { showWelcomeScreen = false }
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Welcome to: How to Use and Enjoy \nExamate",
                                    textAlign = TextAlign.Center,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    text = "Tap anywhere on the screen to \ncontinue",
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center,
                                    color = Green
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    NaviegationTheme {
        NavHostScreen()
    }
}