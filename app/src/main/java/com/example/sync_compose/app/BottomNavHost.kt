package com.example.sync_compose.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.sync_compose.R
import com.example.sync_compose.screens.ChattingScreen
import com.example.sync_compose.screens.CommunityScreen
import com.example.sync_compose.screens.HomeScreen
import com.example.sync_compose.screens.MypageScreen

sealed class BottomNavItem(
    val title: Int, val icon: Int, val route: String
) {
    object Home : BottomNavItem(R.string.sync, R.drawable.ic_bnv_home, "home")
    object Community : BottomNavItem(R.string.community, R.drawable.ic_bnv_community, "community")
    object Chatting : BottomNavItem(R.string.chatting, R.drawable.ic_bnv_chat, "chatting")
    object My : BottomNavItem(R.string.my, R.drawable.ic_bnv_my, "my")
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(route = BottomNavItem.Home.route){
            HomeScreen()
        }
        composable(route = BottomNavItem.Community.route){
            CommunityScreen()
        }
        composable(route = BottomNavItem.Chatting.route){
            ChattingScreen()
        }
        composable(route = BottomNavItem.My.route){
            MypageScreen()
        }
    }
}