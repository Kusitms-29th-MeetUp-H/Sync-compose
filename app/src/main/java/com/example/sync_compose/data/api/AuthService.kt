package com.example.sync_compose.data.api

import com.example.sync_compose.data.base.ApiResponse
import com.example.sync_compose.data.model.auth.request.PlatformRequest
import com.example.sync_compose.data.model.auth.response.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {

    @POST("auth/signin")
    suspend fun signIn(
//        @Header("Content-Type") application: String,
//        @Header("Authorization") accessToken: String,
        @Header("fcmToken") fcmToken: String,
        @Body platform: PlatformRequest
    ): Response<ApiResponse<SignInResponse>>
}