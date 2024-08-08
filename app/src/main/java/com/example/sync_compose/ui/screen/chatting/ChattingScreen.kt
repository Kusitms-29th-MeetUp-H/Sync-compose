package com.example.sync_compose.ui.screen.chatting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sync_compose.ui.theme.SyncTheme
import com.example.sync_compose.ui.util.SetStatusBarColor

@Composable
fun ChattingScreen() {
    SyncTheme {
        SetStatusBarColor()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Chatting screen")
    }
}
