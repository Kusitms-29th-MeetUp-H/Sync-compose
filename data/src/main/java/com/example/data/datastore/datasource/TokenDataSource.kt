package com.example.data.datastore.datasource

interface TokenDataSource {

    suspend fun setAccessToken(accessToken: String)

    suspend fun setRefreshToken(refreshToken: String)

    suspend fun setFcmDeviceToken(fcmDeviceToken: String)

    suspend fun getAccessToken(): String

    suspend fun getRefreshToken(): String

    suspend fun getFcmDeviceToken(): String

    suspend fun clear()

}