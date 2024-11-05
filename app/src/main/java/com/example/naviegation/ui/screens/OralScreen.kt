package com.example.naviegation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.naviegation.ui.theme.Green
import com.example.naviegation.ui.theme.LightMintGreen
import com.example.naviegation.ui.theme.White

@Composable
fun OralScreen() {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.ExitToApp,
                onClick = {

                }
            )
        }
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.ThumbUp,
                onClick = { /* Handle click */ }
            )
        }
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.Star,
                onClick = { /* Handle click */ }
            )
        }
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.Share,
                onClick = { /* Handle click */ }
            )
        }
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.Info,
                onClick = { /* Handle click */ }
            )
        }
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.Star,
                onClick = { /* Handle click */ }
            )
        }
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.Star,
                onClick = { /* Handle click */ }
            )
        }
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.Star,
                onClick = { /* Handle click */ }
            )
        }
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.Star,
                onClick = { /* Handle click */ }
            )
        }
        item {
            InfoCard(
                title1 = "5 out of 10 questions",
                title2 = "Voyage",
                iconRes = Icons.Default.Star,
                onClick = { /* Handle click */ }
            )
        }
    }
}

@Composable
fun InfoCard(
    title1: String,
    title2: String,
    title3 :String= "Progress %70",
    iconRes: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = title1,
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.background(color = LightMintGreen)
            )
            Row ( verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = iconRes,
                    contentDescription = null,
                    tint = Color.Gray, // Customize the color if needed
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = title2,
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title3,
                color = Color.Gray,
                fontSize = 14.sp,


                )
            LinearProgressIndicator(
                progress = { 0.7f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                color = Green,
            )

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InfoCardPreview() {

    OralScreen()
}