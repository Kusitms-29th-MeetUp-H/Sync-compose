package com.example.sync_compose.data.model.auth.response

data class SignInResponse(
    val userId: Int,
    val email: String,
    val name: String,
    val picture: String,
    val accessToken: String,
    val refreshToken: String,
    val isFirst: Boolean,
    val sessionId: String
)
