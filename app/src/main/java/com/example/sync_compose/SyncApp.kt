package com.example.sync_compose

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SyncApp: Application() {
    override fun onCreate() {
        super.onCreate()

        initKakaoLogin()
    }

    private fun initKakaoLogin() {
        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
    }
}