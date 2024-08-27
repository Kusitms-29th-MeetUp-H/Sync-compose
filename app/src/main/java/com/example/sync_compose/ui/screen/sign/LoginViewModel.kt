package com.example.sync_compose.ui.screen.sign

import com.example.sync_compose.domain.KakaoClientResult
import com.example.sync_compose.domain.usecase.KakaoLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
class LoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase
) {

    private fun kakaoLogin(kakaoClientResult: KakaoClientResult) {
        //TODO
        kakaoLoginUseCase
    }
}