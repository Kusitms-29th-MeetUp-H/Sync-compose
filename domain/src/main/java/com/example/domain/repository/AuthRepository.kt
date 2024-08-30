package com.example.domain.repository

interface AuthRepository {

    suspend fun kakaoLogin(accessToken: String)

    suspend fun logout()

    suspend fun updateLocalAccessToken(token: String)

}