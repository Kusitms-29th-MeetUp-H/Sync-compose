package com.example.sync_compose.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sync_compose.ui.theme.SyncColors
import com.example.sync_compose.ui.theme.SyncTypography

@Composable
fun TabComponent(
    tabs: List<String>,
    contents: List<@Composable () -> Unit>,
    initialSelectedIndex: Int = 0
) {
    var selectedTabIndex by remember { mutableStateOf(initialSelectedIndex) }

    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = SyncColors().white,
            contentColor = SyncColors().biscay50,
        ) {
            tabs.forEachIndexed { index, title ->
                val isSelected = selectedTabIndex == index
                Tab(
                    text = {
                        Text(
                            text = title,
                            style = if (isSelected)
                                SyncTypography().body2_700.copy(color = SyncColors().biscay50)
                            else
                                SyncTypography().body2_400.copy(color = SyncColors().gray50)
                        )
                    },
                    selected = isSelected,
                    onClick = { selectedTabIndex = index }
                )
            }
        }
        // 컨텐츠 뷰 변경
        contents[selectedTabIndex]()
    }
}