package com.example.sync_compose.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class SyncColors(
    /*biscay*/
    val biscay5: Color = Color(0xFFEEFFF9),
    val biscay10: Color = Color(0xFFC0F8E4),
    val biscay30: Color = Color(0xFF76E3BC),
    val biscay50: Color = Color(0xFF1BD18F),
    val biscay70: Color = Color(0xFF16A772),
    val biscay90: Color = Color(0xFF0B5439),
    val biscay100: Color = Color(0xFF052A1D),

    /*gray*/
    val gray5: Color = Color(0xFFF8F8F9),
    val gray10: Color = Color(0xFFF0F0F0),
    val gray30: Color = Color(0xFFD8D8D8),
    val gray50: Color = Color(0xFF8E8E8E),
    val gray70: Color = Color(0xFF555555),
    val gray90: Color = Color(0xFF404040),
    val gray100: Color = Color(0xFF111111),

    /*violet*/
    val violet5: Color = Color(0xFFEFECFE),
    val violet10: Color = Color(0xFFCEC7FD),
    val violet30: Color = Color(0xFF9E8FFB),
    val violet50: Color = Color(0xFF5D44F9),
    val violet70: Color = Color(0xFF39299E),
    val violet90: Color = Color(0xFF150E43),
    val violet100: Color = Color(0xFF030115),

    /*purple*/
    val purple200: Color = Color(0xFFFFBB86FC),
    val purple500: Color = Color(0xFFFF6200EE),
    val purple700: Color = Color(0xFFFF3700B3),

    /*teal*/
    val teal200: Color = Color(0xFFFF03DAC5),
    val teal700: Color = Color(0xFFFF018786),

    /*etc*/
    val black: Color = Color(0xFF000000),
    val white: Color = Color(0xFFFFFFFF),
    val primary: Color = Color(0xFF1BD18F),
    val danger50: Color = Color(0xFFFF3C3C),
    val transparent: Color = Color(0x1A000000),
    val translate: Color = Color(0x00000000),
)

val LocalColors = staticCompositionLocalOf { SyncColors() }
