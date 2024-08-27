package com.example.sync_compose.datastore.datasource

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TokenDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
): TokenDataSource {

    private companion object {
        val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
        val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
        val FCM_TOKEN_KEY = stringPreferencesKey("fcm_token")
    }

    private val Context.tokenDataStore by preferencesDataStore("sync_data_store")

    override suspend fun setAccessToken(accessToken: String) {
        context.tokenDataStore.edit { prefs ->
            prefs[ACCESS_TOKEN_KEY] = accessToken
        }
    }

    override suspend fun setRefreshToken(refreshToken: String) {
        context.tokenDataStore.edit { prefs ->
            prefs[REFRESH_TOKEN_KEY] = refreshToken
        }
    }

    override suspend fun setFcmDeviceToken(fcmDeviceToken: String) {
        context.tokenDataStore.edit { prefs ->
            prefs[FCM_TOKEN_KEY] = fcmDeviceToken
        }
    }

    override suspend fun getAccessToken(): String {
        return context.tokenDataStore.data.map { prefs ->
            prefs[ACCESS_TOKEN_KEY]?.toString() ?: ""
        }.first()
    }

    override suspend fun getRefreshToken(): String {
        return context.tokenDataStore.data.map { prefs ->
            prefs[REFRESH_TOKEN_KEY]?.toString() ?: ""
        }.first()
    }

    override suspend fun getFcmDeviceToken(): String {
        return context.tokenDataStore.data.map { prefs ->
            prefs[FCM_TOKEN_KEY]?.toString() ?: ""
        }.first()
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }

}