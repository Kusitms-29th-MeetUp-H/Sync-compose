package com.example.domain.usecase

import com.example.domain.repository.AuthRepository
import com.example.domain.base.ApiState
import com.example.domain.base.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginWithKakaoUseCase @Inject constructor(
    private val authRepository: AuthRepository
): UseCase<String, ApiState<Nothing>>() {

    override suspend fun invoke(request: String): Flow<ApiState<Nothing>> {
        TODO("Not yet implemented")
    }
}