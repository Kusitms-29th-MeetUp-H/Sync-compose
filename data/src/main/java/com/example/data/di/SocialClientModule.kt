package com.example.data.di

import com.example.data.KakaoClient
import com.example.data.KakaoClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class SocialClientModule {

    @Binds
    abstract fun bindsKakaoClient(kakaoClientImpl: KakaoClientImpl): KakaoClient
}