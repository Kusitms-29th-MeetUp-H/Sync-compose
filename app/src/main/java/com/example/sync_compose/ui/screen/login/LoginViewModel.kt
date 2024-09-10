package com.example.sync_compose.ui.screen.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.sync_compose.data.model.LogInResponse
import com.example.sync_compose.data.model.Platform
import com.example.sync_compose.data.network.LoginService
import com.example.sync_compose.data.repository.KakaoAuthRepository
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val kakaoAuthRepository: KakaoAuthRepository,
    private val loginService: LoginService
) : ViewModel() {

    fun loginWithKakao(context: Context, onLoginSuccess: () -> Unit) {
        kakaoAuthRepository.loginWithKakao(context,
            onSuccess = { accessToken ->
                Toast.makeText(context, "로그인 성공: $accessToken", Toast.LENGTH_SHORT).show()

                // 로그인 성공 시 서버로 로그인 정보 전달
                sendLoginToServer(context, "kakao", accessToken)
                Log.d("LoginViewModel", "카카오 로그인 후 반환된 액세스 토큰: $accessToken")

                onLoginSuccess() // 성공 시 콜백 호출
            },
            onError = { error ->
                Toast.makeText(context, "로그인 실패: ${error.message}", Toast.LENGTH_SHORT).show()
            })
    }

    fun sendLoginToServer(context: Context, platform: String, accessToken: String) {
        val sharedPreferences = context.getSharedPreferences("my_token", Context.MODE_PRIVATE)
        val fcmToken = sharedPreferences.getString("fcm_token", "1234") ?: "1234"

        // 서버로 로그인 요청하기 전에 토큰 갱신이 필요한지 확인하고 갱신
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Log.e("LoginViewModel", "토큰 정보 조회 실패: ${error.message}")
                Toast.makeText(context, "토큰 정보 조회 실패", Toast.LENGTH_SHORT).show()
            } else if (tokenInfo != null) {
                // 토큰이 유효하면 서버로 로그인 요청
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val call: Call<LogInResponse> = loginService.signIn(
                            "application/json", "Bearer $accessToken", fcmToken,
                            Platform(platform)
                        )

                        call.enqueue(object : Callback<LogInResponse> {
                            override fun onResponse(
                                call: Call<LogInResponse>, response: Response<LogInResponse>
                            ) {
                                if (response.isSuccessful) {
                                    val loginResponse = response.body()
                                    loginResponse?.let {
                                        Log.d("LoginViewModel", "로그인 성공: ${it.data.name}")
                                        CoroutineScope(Dispatchers.Main).launch {
                                            Toast.makeText(
                                                context,
                                                "로그인 성공: ${it.data.name}",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }
                                } else {
                                    Log.e("LoginViewModel", "로그인 실패: ${response.errorBody()?.string()}")
                                    CoroutineScope(Dispatchers.Main).launch {
                                        Toast.makeText(context, "로그인 실패", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }

                            override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                                Log.e("LoginViewModel", "로그인 요청 실패", t)
                                CoroutineScope(Dispatchers.Main).launch {
                                    Toast.makeText(context, "로그인 요청 실패", Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
                    } catch (e: Exception) {
                        Log.e("LoginViewModel", "로그인 요청 실패", e)
                        CoroutineScope(Dispatchers.Main).launch {
                            Toast.makeText(context, "로그인 요청 실패", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Log.e("LoginViewModel", "토큰이 만료되었습니다. 카카오 로그인을 다시 시도합니다.")
                refreshAccessToken(context)
            }
        }
    }

    // 액세스 토큰 만료 시 다시 로그인하는 함수
    private fun refreshAccessToken(context: Context) {
        kakaoAuthRepository.loginWithKakao(context,
            onSuccess = { newAccessToken ->
                Log.d("LoginViewModel", "토큰 갱신 성공: $newAccessToken")
                sendLoginToServer(context, "kakao", newAccessToken)
            },
            onError = { error ->
                Log.e("LoginViewModel", "토큰 갱신 실패: ${error.message}")
                Toast.makeText(context, "토큰 갱신 실패", Toast.LENGTH_SHORT).show()
            })
    }
}
