package com.example.naviegation.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ConnectScreen(navController: NavHostController) {
    Text(text = "Connect Screen", Modifier.fillMaxWidth().size(64.dp))
}