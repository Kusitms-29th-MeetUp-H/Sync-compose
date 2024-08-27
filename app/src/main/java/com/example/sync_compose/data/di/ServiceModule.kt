package com.example.sync_compose.data.di

import com.example.sync_compose.data.api.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideAuthService(@DefaultRetrofit retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}