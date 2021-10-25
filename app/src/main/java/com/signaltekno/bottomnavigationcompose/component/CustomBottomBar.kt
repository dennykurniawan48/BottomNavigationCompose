package com.signaltekno.bottomnavigationcompose.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.signaltekno.bottomnavigationcompose.model.BottomNavItem

@ExperimentalMaterialApi
@Composable
fun CustomBottomBar(items: List<BottomNavItem>,
                    navController: NavController,
                    onItemClick: (BottomNavItem) -> Unit) {

    BottomNavigation(
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if(item.badgeCount > 0){
                            BadgeBox( badgeContent = {
                                Text(text = item.badgeCount.toString())
                            }){
                                Icon(imageVector = item.icon, contentDescription = item.name)
                            }
                        }else{
                            Icon(imageVector = item.icon, contentDescription = item.name)
                        }
                        if(selected){
                            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                        }
                    }
                }
            )
        }
    }
}