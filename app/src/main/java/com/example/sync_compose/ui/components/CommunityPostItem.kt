package com.example.sync_compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.sync_compose.R
import com.example.data.model.community.CommunityPost
import com.example.sync_compose.ui.theme.SyncColors
import com.example.sync_compose.ui.theme.SyncTypography


@Composable
fun CommunityPostItem(post: CommunityPost) {
    Row {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberAsyncImagePainter(post.writerImage),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = post.writerName,
                    style = SyncTypography().detail700.copy(color = SyncColors().gray70)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = post.createdDate,
                    style = SyncTypography().body3_400.copy(color = SyncColors().gray50)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = post.title,
                style = SyncTypography().body3_700.copy(color = SyncColors().gray90)
            )
            Text(
                text = post.content,
                style = SyncTypography().body3_400.copy(color = SyncColors().gray90)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_thumbs_up),
                    contentDescription = "Likes",
                    modifier = Modifier.size(14.dp),
                    tint = SyncColors().biscay50
                )
                Text(
                    text = post.likeCnt.toString(),
                    style = SyncTypography().body3_400.copy(color = SyncColors().biscay50)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = "Comments",
                    modifier = Modifier.size(14.dp),
                    tint = SyncColors().biscay50
                )
                Text(
                    text = post.commentCnt.toString(),
                    style = SyncTypography().body3_400.copy(color = SyncColors().biscay50)
                )
            }

        }
        post.representativeImage?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = "Post Image",
                modifier = Modifier
                    .height(65.dp)
                    .fillMaxWidth()
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewCommunityPostItem() {
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