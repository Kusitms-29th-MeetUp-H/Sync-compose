package com.example.sync_compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sync_compose.ui.screen.chatting.ChattingScreen
import com.example.sync_compose.ui.screen.community.CommunityScreen
import com.example.sync_compose.ui.screen.home.HomeScreen
import com.example.sync_compose.ui.screen.my.MyScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("community") { CommunityScreen() }
        composable("chatting") { ChattingScreen() }
        composable("my") { MyScreen() }
    }
}