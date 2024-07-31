package com.example.sync_compose.ui.screen.community

fun communityReducer(currentState: CommunityState, intent: CommunityIntent): CommunityState {
    return when (intent) {
        is CommunityIntent.LoadData -> currentState.copy(isLoading = true)
        is CommunityIntent.ShowMessage -> currentState.copy(message = intent.message)
    }
}