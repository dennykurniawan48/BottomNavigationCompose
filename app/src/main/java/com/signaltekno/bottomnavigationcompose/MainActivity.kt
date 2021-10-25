package com.signaltekno.bottomnavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.signaltekno.bottomnavigationcompose.component.CustomBottomBar
import com.signaltekno.bottomnavigationcompose.model.BottomNavItem
import com.signaltekno.bottomnavigationcompose.navigation.Screen
import com.signaltekno.bottomnavigationcompose.navigation.SetupNavigation
import com.signaltekno.bottomnavigationcompose.ui.theme.BottomNavigationComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BottomNavigationComposeTheme {
                Scaffold(
                    content = { paddingValues ->
                        SetupNavigation(navController = navController, paddingBottom = paddingValues.calculateBottomPadding())
                    },
                    bottomBar = {
                        CustomBottomBar(items = listOf(
                            BottomNavItem(name="Home", route = Screen.Home.route, Icons.Filled.Home),
                            BottomNavItem(name="Chat", route = Screen.Chat.route, Icons.Filled.Send),
                            BottomNavItem(name="Setting", route = Screen.Setting.route, Icons.Filled.Settings)
                        ), navController = navController, onItemClick = {navController.navigate(it.route)})
                    }
                )
            }
        }
    }
}