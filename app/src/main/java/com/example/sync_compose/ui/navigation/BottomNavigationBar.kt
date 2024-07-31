package com.example.sync_compose.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sync_compose.R

data class BottomNavItem(val route: String, val label: String, val icon: Int)

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("home", "Home", R.drawable.ic_bnv_home),
        BottomNavItem("community", "Community", R.drawable.ic_bnv_community),
        BottomNavItem("chatting", "Chatting", R.drawable.ic_bnv_chat),
        BottomNavItem("my", "My", R.drawable.ic_bnv_my)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(Color.Transparent)
            .border(1.dp, color = Color.Cyan, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ) {
        BottomNavigation(
            modifier = Modifier.height(78.dp),
            backgroundColor = Color.Black,
            elevation = 20.dp
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    modifier = Modifier.padding(vertical = 16.dp),
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.label
                        )
                    },
                    label = { Text(item.label) },
                    selected = currentRoute == item.route,
                    selectedContentColor = Color.Blue,
                    unselectedContentColor = Color.Red,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

}