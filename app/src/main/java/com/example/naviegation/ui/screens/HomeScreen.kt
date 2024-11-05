package com.example.naviegation.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.naviegation.ui.theme.BlackF

@Composable
fun HomeScreen(navController: NavHostController) {
    var isTooltipVisible by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .pointerInput(Unit) {
                // Disable clicks on the screen when the tooltip is not visible
                if (isTooltipVisible) {
                    detectTapGestures(onTap = {
                        isTooltipVisible = false
                    }) // Dismiss tooltip on tap
                }
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header
            Text(
                text = "Home",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF008080)
            )

            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 12.dp),
                text = "Hi User Name",
                fontSize = 18.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Study Plan",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            StudyUnitsList()
        }

        Tooltip(
            isVisible = isTooltipVisible,
            modifier = Modifier.align(Alignment.BottomStart) // Align at the bottom start
        )
    }
}

@Composable
fun Tooltip(
    isVisible: Boolean,
    modifier: Modifier = Modifier // Allow passing a modifier for custom positioning
) {
    if (isVisible) {
        Box(
            modifier = modifier
                .padding(8.dp) // Padding around the entire tooltip
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFF1F2937),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        text = "Vous trouverez ici votre plan d'étude",
                        modifier = Modifier.padding(8.dp),
                        color = Color.White
                    )
                }

                TriangleArrow(color = Color(BlackF.value))
            }
        }
    }
}

@Composable
fun TriangleArrow(color: Color) {
    Canvas(modifier = Modifier.size(12.dp)) {
        drawTriangle(color)
    }
}

private fun DrawScope.drawTriangle(color: Color) {
    val triangleOffset = 8.dp.toPx()

    val path = androidx.compose.ui.graphics.Path().apply {
        moveTo(
            size.width / 2 + triangleOffset,
            size.height
        )
        lineTo(0f + triangleOffset, 0f)
        lineTo(size.width + triangleOffset, 0f)
        close()
    }
    drawPath(path, color)
}

@Composable
fun StudyUnitsList() {
    val units = listOf(
        "Unite 1:\nwhat is examate" to true,
        "Unite 2:\nwhat is TCF" to false,
        "Writing Tasks" to false,
        "Oral Task" to false
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        units.forEachIndexed { index, (title, isUnlocked) ->
            StudyUnitItem(index + 1, title, isUnlocked)
        }
    }
}

@Composable
fun StudyUnitItem(number: Int, title: String, isUnlocked: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(
                    if (isUnlocked) Color(0xFF008080) else Color.LightGray,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = number.toString(),
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = if (isUnlocked) Color.Black else Color.Gray
            )
        }
    }

}

@Preview(showBackground = true) // Use showBackground for a better visual context
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController()) // Create a mock NavHostController
}
