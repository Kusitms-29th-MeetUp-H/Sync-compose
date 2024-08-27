package com.example.sync_compose.data.repository

import com.example.sync_compose.data.source.AuthDataSource
import com.example.sync_compose.datastore.datasource.TokenDataSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val tokenDataSource: TokenDataSource
) : AuthRepository {

    override suspend fun kakaoLogin(accessToken: String) {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        val accessToken = tokenDataSource.getAccessToken()
        // 로그아웃
    }

    override suspend fun updateLocalAccessToken(token: String) {
        tokenDataSource.setAccessToken(accessToken = token)
    }
}