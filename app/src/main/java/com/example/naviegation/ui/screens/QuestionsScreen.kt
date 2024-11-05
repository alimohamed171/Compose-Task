package com.example.naviegation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.naviegation.R
import com.example.naviegation.ui.theme.Green
import com.example.naviegation.ui.theme.MintGray
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionsScreen(navController: NavHostController) {

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { QuestionTabs.entries.size })
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Questions",
                    fontWeight = FontWeight.Bold,
                    color = Green
                )
            })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex.value,
                modifier = Modifier.fillMaxWidth(),
            ) {
                QuestionTabs.entries.forEachIndexed { index, currentTab ->
                    Tab(
                        selected = selectedTabIndex.value == index,
                        selectedContentColor = Green,
                        unselectedContentColor = MintGray,
                        modifier = Modifier.weight(1f),
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(currentTab.ordinal)
                            }
                        },
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Icon(
                                    painter = painterResource(currentTab.iconRes),
                                    contentDescription = "Tab Icon",
                                    modifier = Modifier.size(24.dp),
                                    tint = if (selectedTabIndex.value == index) Green else MintGray
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = currentTab.text)
                            }
                        }
                    )
                }
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center

                ) {
                    if (selectedTabIndex.value == 1) {
                        OralScreen()
                    } else {
                        WritingScreen()
                    }
                }
            }
        }
    }
}

enum class QuestionTabs(
    val iconRes: Int,
    val text: String
) {
    Writing(
        iconRes = R.drawable.pen,
        text = "Writing"
    ),
    Oral(
        iconRes = R.drawable.mic,
        text = "Oral"
    ),
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuestionsScreenPreview() {
    QuestionsScreen(navController = rememberNavController())
}


