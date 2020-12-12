package com.netlsd.musefm.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.netlsd.musefm.Screen
import com.netlsd.musefm.util.destination

@Composable
fun ContentRoute(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.routeId) {
        destination(Screen.Home) {
            HomeScreen()
        }

        destination(Screen.History) {
            HistoryScreen()
        }

        destination(Screen.Settings) {
            SettingsScreen()
        }
    }
}