package com.example.sync_compose.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class SyncColors (
    val biscay_5 : Color = Color(0xFFEEFFF9),
    val biscay_10 : Color = Color(0xFFC0F8E4),
    val biscay_30 : Color = Color(0xFF76E3BC),
    val biscay_50 : Color = Color(0xFF1BD18F),
    val biscay_70 : Color = Color(0xFF16A772),
    val biscay_90 : Color = Color(0xFF0B5439),
    val biscay_100 : Color = Color(0xFF052A1D),

    val gray_5 : Color = Color(0xFFF8F8F9),
    val gray_10 : Color = Color(0xFFF0F0F0),
    val gray_30 : Color = Color(0xFFD8D8D8),
    val gray_50 : Color = Color(0xFF8E8E8E),
    val gray_70 : Color = Color(0xFF555555),
    val gray_90 : Color = Color(0xFF404040),
    val gray_100 : Color = Color(0xFF111111),

    val violet_5 : Color = Color(0xFFEFECFE),
    val violet_10 : Color = Color(0xFFCEC7FD),
    val violet_30 : Color = Color(0xFF9E8FFB),
    val violet_50 : Color = Color(0xFF5D44F9),
    val violet_70 : Color = Color(0xFF39299E),
    val violet_90 : Color = Color(0xFF150E43),
    val violet_100 : Color = Color(0xFF030115),

    val primary : Color = Color(0xFF1BD18F),
)

val LocalColors = staticCompositionLocalOf { SyncColors() }