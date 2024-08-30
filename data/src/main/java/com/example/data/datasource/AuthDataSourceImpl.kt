package com.example.data.datasource

import com.example.data.api.AuthService
import com.example.data.base.ApiResponse
import com.example.data.model.auth.request.PlatformRequest
import com.example.data.model.auth.response.SignInResponse
import retrofit2.Response
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthDataSource {

    override suspend fun signIn(request: PlatformRequest): Response<ApiResponse<SignInResponse>> =
        authService.signIn(fcmToken = "", platform = request)

}