package com.example.sync_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sync_compose.ui.navigation.AppNavGraph
import com.example.sync_compose.ui.navigation.BottomNavigationBar
import com.example.sync_compose.ui.navigation.SetupNavGraph
import com.example.sync_compose.ui.screen.home.HomeScreen
import com.example.sync_compose.ui.screen.login.LoginScreen
import com.example.sync_compose.ui.theme.SyncTheme
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SyncTheme {
                val navController = rememberNavController() // NavController 생성
                AppNavGraph(navController) // NavGraph에 NavController 전달
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            SetupNavGraph(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SyncTheme {
        HomeScreen()
    }
}
