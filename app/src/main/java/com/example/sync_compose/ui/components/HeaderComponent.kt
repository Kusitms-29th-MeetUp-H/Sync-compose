package com.example.sync_compose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sync_compose.R
import com.example.sync_compose.ui.theme.SyncColors
import com.example.sync_compose.ui.theme.SyncTypography

@Composable
fun HeaderComponent(
    showBackButton: Boolean = false,
    showCloseButton: Boolean = false,
    title: String = "",
    showShareButton: Boolean = false,
    showMoreButton: Boolean = false,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = SyncColors().white)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showBackButton) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = "Comments",
                    modifier = Modifier.size(24.dp),
                )
            }
            if (showCloseButton) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "Comments",
                    modifier = Modifier.size(24.dp),
                )
            }
            Text(
                text = title,
                style = SyncTypography().body2_700.copy(SyncColors().gray90),
                textAlign = TextAlign.Start
            )
            if (showShareButton) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = "Comments",
                    modifier = Modifier.size(24.dp),
                )
            }
            if (showMoreButton) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_more),
                    contentDescription = "Comments",
                    modifier = Modifier.size(24.dp),
                )
            }
        }
    }
}