package com.example.sync_compose.data.base

import com.google.gson.annotations.SerializedName

data class ApiResponse<Vo>(
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data:  Vo? = null
)