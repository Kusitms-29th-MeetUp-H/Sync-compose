package com.example.sync_compose.ui.util

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.sync_compose.ui.theme.SyncColors

@Composable
fun SetStatusBarColor(color: Color = SyncColors().white, useDarkIcons: Boolean = true) {
    val context = LocalContext.current
    SideEffect {
        (context as? Activity)?.window?.apply {
            // API 레벨에 따라 상태 표시줄 색상 설정
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                statusBarColor = color.toArgb()
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // 상태 표시줄 아이콘 및 텍스트 색상을 어두운 색으로 설정할 지 결정
                decorView.systemUiVisibility = if (useDarkIcons) {
                    decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                }
            }
        }
    }
}


