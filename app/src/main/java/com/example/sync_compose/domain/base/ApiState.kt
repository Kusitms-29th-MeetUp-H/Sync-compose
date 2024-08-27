package com.example.sync_compose.domain.base

sealed class ApiState<out T> {
    object Loading : ApiState<Nothing>()
    data class Success<T>(val data : T) : ApiState<T>()
    data class Error<T>(val data : T?, val errorCode : String) : ApiState<T>()
}