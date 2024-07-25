package com.example.sync_compose.app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sync_compose.ui.theme.SyncTheme

@Composable
fun BottomNavBar(navController: NavController) {
    val screens = listOf<BottomNavItem>(
        BottomNavItem.Home,
        BottomNavItem.Community,
        BottomNavItem.Chatting,
        BottomNavItem.My
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape( topStart = 24.dp, topEnd = 24.dp ))
            .background(Color.Transparent)
            .border(
                1.dp,
                SyncTheme.colors.gray_10,
                RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
    ) {
        BottomNavigation (
            modifier = Modifier
                .height(78.dp),
            backgroundColor = Color.White,
            elevation = 20.dp
        ) {
            screens.forEach { screens ->
                AddItem(item = screens, currentDestination = currentDestination, navController = navController)
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    item: BottomNavItem,
    currentDestination: NavDestination?,
    navController: NavController
) {
    BottomNavigationItem(
        label = {
            Text(text = stringResource(id = item.title), fontSize = 10.sp)
        },
        icon = {
            Icon(painter = painterResource(item.icon), contentDescription = item.route)
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == item.route
        } == true,
        selectedContentColor = SyncTheme.colors.gray_70,
        unselectedContentColor = SyncTheme.colors.gray_30,
        onClick = {
            navController.navigate(item.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop =true
            }
        },
        modifier = Modifier
            .padding(vertical = 16.dp)
    )
}