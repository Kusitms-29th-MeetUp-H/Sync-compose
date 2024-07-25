package com.example.sync_compose.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

fun colors() = SyncColors()
fun fonts() = SyncTypography()

@Composable
fun SyncTheme (
    colors: SyncColors = colors(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    SideEffect {
        if (!view.isInEditMode) {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
        }
    }
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides fonts()
    ) {
        content()
    }
}