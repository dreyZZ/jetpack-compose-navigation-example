package com.dreyzz.navigationexample.ui.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dreyzz.navigationexample.ui.screens.DetailScreen
import com.dreyzz.navigationexample.ui.screens.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.MainScreen.path) {
        composable(route = Route.MainScreen.path) {
            MainScreen(navController = navController)
        }
        composable(
            route = Route.DetailScreen.path + "?name={name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "dreyZZ"
                }
            )
        ) {
            DetailScreen(name = it.arguments?.getString("name"))
        }
    }
}