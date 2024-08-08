package com.example.sync_compose.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sync_compose.ui.theme.SyncColors
import com.example.sync_compose.ui.theme.SyncTheme
import com.example.sync_compose.ui.util.SetStatusBarColor

@Composable
fun HomeScreen() {
    SyncTheme {
        SetStatusBarColor(color = SyncColors().biscay50, useDarkIcons = false)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SyncColors().white),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home screen")
    }
}