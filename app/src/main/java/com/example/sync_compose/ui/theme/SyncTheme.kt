package com.example.sync_compose.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object SyncTheme {
    val colors: SyncColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: SyncTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}