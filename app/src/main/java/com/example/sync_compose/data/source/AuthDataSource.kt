package com.example.sync_compose.data.source

import com.example.sync_compose.data.base.ApiResponse
import com.example.sync_compose.data.model.auth.request.PlatformRequest
import com.example.sync_compose.data.model.auth.response.SignInResponse
import retrofit2.Response

interface AuthDataSource {

    suspend fun signIn(request: PlatformRequest) : Response<ApiResponse<SignInResponse>>
}