package com.example.sync_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sync_compose.ui.theme.SyncTypography
import com.example.sync_compose.R
import com.example.sync_compose.ui.theme.SyncColors

@Composable
fun CommunityIntroItem(title: Int, detail: Int, img: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = SyncColors().biscay5, shape = RoundedCornerShape(4.dp))
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = stringResource(title),
                    style = SyncTypography().body2_700.copy(SyncColors().gray90),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(detail),
                    style = SyncTypography().detail400.copy(SyncColors().gray70),
                    textAlign = TextAlign.Start
                )
            }
            Image(
                painter = painterResource(id = img),
                contentDescription = "Help Image",
                modifier = Modifier
                    .size(90.dp, 74.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHelpBox() {
    CommunityIntroItem(
        title = R.string.share_everyday_life,
        detail = R.string.recommend_restaurants_info,
        img = R.drawable.img_community_1
    )
}