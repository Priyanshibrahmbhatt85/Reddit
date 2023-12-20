package com.tinder.redditapp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tinder.redditapp.ui.theme.Toolbar
import com.tinder.redditapp.ui.theme.screens.DetailScreen
import com.tinder.redditapp.ui.theme.screens.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.HomeScreen.route) {
            Scaffold(
                topBar = {
                    Toolbar(
                        title = "Home",
                        navController = navController,
                        false
                    )
                }) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    HomeScreen(navController = navController)
                }
            }
        }
        composable(
            route = Screens.DetailScreen.route + "/{title}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType }
                )
        ) {
            val title = it.arguments?.getString("title") ?: ""
            Scaffold(
                topBar = {
                    Toolbar(
                        title = "",
                        navController = navController,
                        true
                    )
                }) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    DetailScreen(title)
                }
            }
        }
    }
}