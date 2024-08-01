package com.example.sync_compose.ui.screen.community

data class CommunityState(
    val isLoading: Boolean = false,
    val data: List<String> = emptyList(),
    val message: String? = null
)
