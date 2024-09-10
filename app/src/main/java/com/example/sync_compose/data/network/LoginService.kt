package com.example.sync_compose.data.network

import com.example.sync_compose.data.model.LogInResponse
import com.example.sync_compose.data.model.OnboardingResponse
import com.example.sync_compose.data.model.Platform
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginService {
    @POST("/auth/login")
    fun signIn(
        @Header("Content-Type") contentType: String,
        @Header("Authorization") authToken: String,
        @Header("FCM-Token") fcmToken: String,
        @Body platform: Platform
    ): Call<LogInResponse>

    @POST("/auth/onboarding")
    fun onboarding(
        @Header("Authorization") authToken: String,
        @Body image: MultipartBody.Part?,
        @Body request: RequestBody
    ): Call<OnboardingResponse>
}
