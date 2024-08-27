package com.example.sync_compose.data.repository

interface AuthRepository {

    suspend fun kakaoLogin(accessToken: String)

    suspend fun logout()

    suspend fun updateLocalAccessToken(token: String)

}