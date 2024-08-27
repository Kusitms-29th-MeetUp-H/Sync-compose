package com.example.sync_compose.domain.usecase

import com.example.sync_compose.data.repository.AuthRepository
import com.example.sync_compose.domain.base.ApiState
import com.example.sync_compose.domain.base.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KakaoLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
): UseCase<String, ApiState<Nothing>>() {

    override suspend fun invoke(request: String): Flow<ApiState<Nothing>> {
        TODO("Not yet implemented")
    }
}