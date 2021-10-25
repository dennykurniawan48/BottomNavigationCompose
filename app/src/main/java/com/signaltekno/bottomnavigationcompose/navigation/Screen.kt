package com.signaltekno.bottomnavigationcompose.navigation

sealed class Screen(val route: String) {
    object Home: Screen("HOME")
    object Chat: Screen("SCREEN")
    object Setting: Screen("Setting")
}