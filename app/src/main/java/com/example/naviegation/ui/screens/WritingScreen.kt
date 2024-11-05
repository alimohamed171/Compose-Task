package com.example.naviegation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.naviegation.R
import com.example.naviegation.ui.theme.MintGray
import com.example.naviegation.ui.theme.White
import com.example.naviegation.utils.ListItem

@Composable
fun WritingScreen() {
    Scaffold { innerPadding ->
        MyList(Modifier.padding(innerPadding))
    }
}

@Composable
fun LazyListItem(item: ListItem) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),

        ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MintGray
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(
                        text = item.title,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MintGray
                    ),
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier.padding(start = 16.dp)


                ) {
                    Text(
                        text = item.task,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp) // Add padding to the text
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.description)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.test),
                        contentDescription = "",
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = "11 answers",
                        fontSize = 12.sp,
                    )
                }

                Text(
                    text = item.date,
                    fontSize = 12.sp,
                )
            }

        }
    }
}

@Composable
fun MyList(padding: Modifier) {
    val listItems = listOf(
        ListItem(
            title = "Events ",
            task = "Task 1",
            description = "Je suis votre collègue, je participe chaque année à une course à pieds pour célébrer le printemps Vous êtes intéressé. Vous me posez des questions pour avoir des informations (parcours, durée, participants, etc.)",
            date = "13 May 2023"
        ),
        ListItem(
            title = "Technology",
            task = "Task 2",
            description = "Quand quelqu'un quitte son pays pour aller vivre ailleurs, c'est souvent parce qu'il n'a pas d'autre choix. Qu'en pensez-vous ?",
            date = "15 May 2023"
        ),
        ListItem(
            title = "Culture",
            task = "Task 3",
            description = "Je suis votre collègue, je participe chaque année à une course à pieds pour célébrer le printemps Vous êtes intéressé. Vous me posez des questions pour avoir des informations (parcours, durée, participants, etc.)",
            date = "15 May 2023"
        ),
        ListItem(
            title = "Culture",
            task = "Task 4",
            description = "Je suis votre collègue, je participe chaque année à une course à pieds pour célébrer le printemps Vous êtes intéressé. Vous me posez des questions pour avoir des informations (parcours, durée, participants, etc.)",
            date = "15 May 2023"
        ),
        ListItem(
            title = "Culture",
            task = "Task 5",
            description = "Je suis votre collègue, je participe chaque année à une course à pieds pour célébrer le printemps Vous êtes intéressé. Vous me posez des questions pour avoir des informations (parcours, durée, participants, etc.)",
            date = "15 May 2023"
        ), ListItem(
            title = "Culture",
            task = "Task 6",
            description = "Je suis votre collègue, je participe chaque année à une course à pieds pour célébrer le printemps Vous êtes intéressé. Vous me posez des questions pour avoir des informations (parcours, durée, participants, etc.)",
            date = "15 May 2023"
        ),
    )

    LazyColumn {
        items(listItems) { item ->
            LazyListItem(item)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WritingScreenPreview() {
    WritingScreen()
}
