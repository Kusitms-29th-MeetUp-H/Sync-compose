package com.example.sync_compose.data.repository

import android.content.Context
import android.util.Log
import com.kakao.sdk.user.UserApiClient
import javax.inject.Inject

class KakaoAuthRepository @Inject constructor() {
    fun loginWithKakao(context: Context, onSuccess: (String) -> Unit, onError: (Throwable) -> Unit) {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    Log.e("KakaoLogin", "KakaoTalk login failed", error)
                    onError(error)
                } else if (token != null) {
                    Log.i("KakaoLogin", "KakaoTalk login success: ${token.accessToken}")
                    onSuccess(token.accessToken)
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
                if (error != null) {
                    Log.e("KakaoLogin", "KakaoAccount login failed", error)
                    onError(error)
                } else if (token != null) {
                    Log.i("KakaoLogin", "KakaoAccount login success: ${token.accessToken}")
                    onSuccess(token.accessToken)
                }
            }
        }
    }
}
