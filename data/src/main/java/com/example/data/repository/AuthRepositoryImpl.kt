package com.example.data.repository

import com.example.data.datasource.AuthDataSource
import com.example.data.datastore.datasource.TokenDataSource
import com.example.domain.repository.AuthRepository
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