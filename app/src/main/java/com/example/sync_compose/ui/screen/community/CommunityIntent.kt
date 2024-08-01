package com.example.sync_compose.ui.screen.community

sealed class CommunityIntent {
    object LoadData : CommunityIntent()
    data class ShowMessage(val message: String) : CommunityIntent()
}