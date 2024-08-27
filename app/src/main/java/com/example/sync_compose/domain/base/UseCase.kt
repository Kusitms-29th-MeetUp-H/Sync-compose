package com.example.sync_compose.domain.base

import kotlinx.coroutines.flow.Flow

abstract class UseCase<REQUEST, RESPONSE> {
    abstract suspend operator fun invoke(request: REQUEST): Flow<RESPONSE>
}