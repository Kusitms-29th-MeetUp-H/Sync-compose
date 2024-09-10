package com.example.data

interface KakaoClient {

    suspend fun login(): KakaoClientResult
}