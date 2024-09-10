package com.example.sync_compose.ui.screen.community

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.sync_compose.R
import com.example.data.model.community.CommunityPost
import com.example.sync_compose.ui.components.CommunityIntroItem
import com.example.sync_compose.ui.components.CommunityPostItem
import com.example.sync_compose.ui.components.TabComponent
import com.example.sync_compose.ui.theme.SyncColors
import com.example.sync_compose.ui.theme.SyncTheme
import com.example.sync_compose.ui.util.SetStatusBarColor

@Composable
fun CommunityScreen() {
    val tabs = listOf("생활", "질문")
    val contents = listOf<@Composable () -> Unit>(
        { LifeContent() },
        { QuestionContent() }
    )

    SyncTheme {
        SetStatusBarColor()
        TabComponent(
            tabs = tabs,
            contents = contents
        )
    }
}

@Composable
fun LifeContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            CommunityIntroItem(
                title = R.string.share_everyday_life,
                detail = R.string.recommend_restaurants_info,
                img = R.drawable.img_community_1
            );
            CommunityPostItem(
                CommunityPost(
                    postId = 1,
                    writerImage = "https://example.com/profile.jpg",
                    writerName = "작성자 명",
                    createdDate = "08:00",
                    postType = "생활",
                    title = "커뮤니티 제목",
                    content = "커뮤니티 내용",
                    likeCnt = 10,
                    commentCnt = 5,
                    representativeImage = "https://example.com/image.jpg",
                    likedByUser = true,
                    postedByUser = true,
                )
            )
        }

    }
}

@Composable
fun QuestionContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            CommunityIntroItem(
                title = R.string.ask_anything,
                detail = R.string.ask_about_life_weather,
                img = R.drawable.img_community_2
            );
            CommunityPostItem(
                CommunityPost(
                    postId = 1,
                    writerImage = "https://example.com/profile.jpg",
                    writerName = "작성자 명",
                    createdDate = "08:00",
                    postType = "생활",
                    title = "커뮤니티 제목",
                    content = "커뮤니티 내용",
                    likeCnt = 10,
                    commentCnt = 5,
                    representativeImage = "https://example.com/image.jpg",
                    likedByUser = true,
                    postedByUser = true,
                )
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCommunityScreen() {
    SyncTheme {
        CommunityScreen()
    }
}
