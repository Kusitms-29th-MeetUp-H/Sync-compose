package com.example.sync_compose.ui.screen.sign

import com.example.data.KakaoClientResult
import com.example.domain.usecase.LoginWithKakaoUseCase
import javax.inject.Inject

//@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWithKakaoUseCase: LoginWithKakaoUseCase
) {

    private fun kakaoLogin(kakaoClientResult: KakaoClientResult) {
        //TODO
        loginWithKakaoUseCase
    }
}