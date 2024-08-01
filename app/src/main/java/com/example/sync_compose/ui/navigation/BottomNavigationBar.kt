package com.example.sync_compose.ui.navigation

import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sync_compose.R
import com.example.sync_compose.ui.theme.SyncColors

data class BottomNavItem(val route: String, val label: String, val icon: Int)

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("home", "싱크", R.drawable.ic_bnv_home),
        BottomNavItem("community", "커뮤니티", R.drawable.ic_bnv_community),
        BottomNavItem("chatting", "채팅", R.drawable.ic_bnv_chat),
        BottomNavItem("my", "마이", R.drawable.ic_bnv_my)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                clip = true,
                ambientColor = Color.Black,
                spotColor = Color.Black
            )
            .background(SyncColors().white)
    ) {
        BottomNavigation(
            modifier = Modifier.height(78.dp),
            backgroundColor = Color.Transparent,
            elevation = 0.dp
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
                    selectedContentColor = SyncColors().gray70,
                    unselectedContentColor = SyncColors().gray30,
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
