package com.example.sync_compose.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.sync_compose.R
import androidx.compose.ui.text.TextStyle

// Font Families
val spoqahansansneoBold = FontFamily(Font(R.font.spoqahansansneo_bold))
val spoqahansansneoRegular = FontFamily(Font(R.font.spoqahansansneo_regular))

data class SyncTypography(
    val heading1: TextStyle = TextStyle(
        fontFamily = spoqahansansneoBold,
        fontSize = 24.sp,
        lineHeight = 29.4.sp,
    ),

    val heading2: TextStyle = TextStyle(
        fontFamily = spoqahansansneoBold,
        fontSize = 22.sp,
        lineHeight = 26.9.sp,
    ),

    val heading3: TextStyle = TextStyle(
        fontFamily = spoqahansansneoBold,
        fontSize = 20.sp,
        lineHeight = 24.5.sp,
    ),

    val heading4: TextStyle = TextStyle(
        fontFamily = spoqahansansneoBold,
        fontSize = 18.sp,
        lineHeight = 22.sp,
    ),

    val body1_400: TextStyle = TextStyle(
        fontFamily = spoqahansansneoRegular,
        fontSize = 16.sp,
        lineHeight = 20.8.sp
    ),

    val body1_700: TextStyle = TextStyle(
        fontFamily = spoqahansansneoBold,
        fontSize = 16.sp,
        lineHeight = 20.8.sp
    ),

    val body2_400: TextStyle = TextStyle(
        fontFamily = spoqahansansneoRegular,
        fontSize = 14.sp,
        lineHeight = 18.2.sp
    ),

    val body2_700: TextStyle = TextStyle(
        fontFamily = spoqahansansneoBold,
        fontSize = 14.sp,
        lineHeight = 18.2.sp
    ),

    val body3_400: TextStyle = TextStyle(
        fontFamily = spoqahansansneoRegular,
        fontSize = 12.sp,
        lineHeight = 15.6.sp,
    ),

    val body3_700: TextStyle = TextStyle(
        fontFamily = spoqahansansneoBold,
        fontSize = 12.sp,
        lineHeight = 15.6.sp
    ),

    val detail400: TextStyle = TextStyle(
        fontFamily = spoqahansansneoRegular,
        fontSize = 11.sp,
        lineHeight = 14.6.sp
    ),

    val detail700: TextStyle = TextStyle(
        fontFamily = spoqahansansneoBold,
        fontSize = 11.sp,
        lineHeight = 14.6.sp
    ),
)

val LocalTypography = staticCompositionLocalOf { SyncTypography() }