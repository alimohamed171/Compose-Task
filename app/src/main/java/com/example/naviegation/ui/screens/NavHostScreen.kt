package com.example.naviegation.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.naviegation.R
import com.example.naviegation.ui.theme.Green
import com.example.naviegation.ui.theme.MintGray
import com.example.naviegation.ui.theme.White
import com.example.naviegation.utils.NavItem

@Composable
fun NavHostScreen() {
    val navController = rememberNavController()
    var bottomBarVisibility by remember {
        mutableStateOf(true)
    }
    Scaffold(
        bottomBar = {
            AnimatedVisibility(visible = bottomBarVisibility) {
                NavigationBottomBar(
                    navController = navController,
                    items = listOf(
                        NavItem("home", R.drawable.home),
                        NavItem("connect", R.drawable.connect),
                        NavItem("questions", R.drawable.question),
                        NavItem("tools", R.drawable.tool),
                        NavItem("profile", R.drawable.profile),
                    )
                )
            }
        }) {
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(it)
        ) {
            composable("home") {
                HomeScreen(navController)
                bottomBarVisibility = true
            }
            composable("profile") {
                ProfileScreen(navController)
                bottomBarVisibility = true

            }
            composable("connect") {
                ConnectScreen(navController)
                bottomBarVisibility = true

            }
            composable("tools") {
                ToolsScreen(navController)
                bottomBarVisibility = true

            }
            composable("questions") {
                QuestionsScreen(navController)
                bottomBarVisibility = true

            }

        }
    }

}

@Composable
fun NavigationBottomBar(
    navController: NavHostController,
    items: List<NavItem>
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    BottomAppBar(containerColor = White) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },

                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                },
                alwaysShowLabel = true,
                label = {
                    Text(text = item.route)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Green,
                    selectedTextColor = Green,
                    indicatorColor = White,
                    unselectedIconColor = MintGray,
                    unselectedTextColor = MintGray
                )
            )
        }
    }
}
