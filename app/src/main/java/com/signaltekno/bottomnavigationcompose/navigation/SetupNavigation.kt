package com.signaltekno.bottomnavigationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.signaltekno.bottomnavigationcompose.screen.HomeView

@Composable
fun SetupNavigation(navController: NavHostController, paddingBottom: Dp) {
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(Screen.Home.route){
            HomeView(paddingBottom = paddingBottom)
        }
        composable(Screen.Chat.route){
            HomeView(paddingBottom = paddingBottom)
        }
        composable(Screen.Setting.route){
            HomeView(paddingBottom = paddingBottom)
        }
    }
}