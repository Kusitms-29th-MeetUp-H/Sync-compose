package com.example.sync_compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sync_compose.MainScreen
import com.example.sync_compose.ui.screen.chatting.ChattingScreen
import com.example.sync_compose.ui.screen.community.CommunityScreen
import com.example.sync_compose.ui.screen.home.HomeScreen
import com.example.sync_compose.ui.screen.login.LoginScreen
import com.example.sync_compose.ui.screen.my.MyScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController) // LoginScreen에 NavController 전달
        }
        composable("main") {
            MainScreen() // MainScreen 호출
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("community") { CommunityScreen() }
        composable("chatting") { ChattingScreen() }
        composable("my") { MyScreen() }
    }
}