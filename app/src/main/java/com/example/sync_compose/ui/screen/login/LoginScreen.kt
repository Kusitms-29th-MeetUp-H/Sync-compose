package com.example.sync_compose.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sync_compose.R
import com.example.sync_compose.ui.theme.SyncColors
import com.example.sync_compose.ui.theme.SyncTheme
import com.example.sync_compose.ui.util.SetStatusBarColor

@Composable
fun LoginScreen(navController: NavController) { // NavController 추가
    val viewModel: LoginViewModel = hiltViewModel() // Hilt로 ViewModel 가져오기
    val context = LocalContext.current // 현재 컨텍스트 가져오기

    SyncTheme {
        SetStatusBarColor(color = SyncColors().biscay50, useDarkIcons = false)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(SyncColors().biscay50)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_kakao),
                contentDescription = "Kakao Image",
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.Center)
                    .clickable {
                        // 이미지 클릭 시 카카오 로그인 함수 호출
                        viewModel.loginWithKakao(
                            context = context,
                            onLoginSuccess = {
                                // 로그인 성공 시 MainScreen으로 이동
                                navController.navigate("main")
                            }
                        )
                    }
            )
        }
    }
}
