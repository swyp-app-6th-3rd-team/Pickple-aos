package com.swyp.data.auth.repository.impl

import com.swyp.data.auth.di.qualifier.AppleAuth
import com.swyp.data.auth.di.qualifier.KakaoAuth
import com.swyp.data.auth.source.SocialAuthDataSource
import com.swyp.domain.auth.model.AuthError
import com.swyp.domain.auth.model.AuthProvider
import com.swyp.domain.auth.model.AuthResult
import com.swyp.domain.auth.repository.AuthRepository
import com.swyp.domain.common.ResultWrapper
import timber.log.Timber
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    @KakaoAuth private val kakaoAuthDataSource: SocialAuthDataSource,
    @AppleAuth private val appleAuthDataSource: SocialAuthDataSource,
) : AuthRepository {

    override suspend fun loginWithSocial(
        provider: AuthProvider,
    ): ResultWrapper<AuthResult, AuthError> {

        val result = when(provider){
            AuthProvider.KAKAO -> kakaoAuthDataSource.login()
            AuthProvider.APPLE -> appleAuthDataSource.login()
        }
        return result.fold(
            // 테스트를 위해 신규 유저(isNewUser = true) 상태를 반환하도록 Mocking
            onSuccess = {
                //Todo: token 저장
                ResultWrapper.Success(
                    AuthResult(
                        accessToken = "dummy_access_token",
                        refreshToken = "dummy_refresh_token",
                        isNewUser = true
                    )
                )
            },
            onFailure = { error  ->
                Timber.d("로그인 실패 ${error.message}")
                ResultWrapper.Failure(AuthError.Unknown(error.message) )
            }
        )
    }

    override suspend fun loginAsGuest(): ResultWrapper<AuthResult, AuthError> {
        return ResultWrapper.Success(
            AuthResult(
                accessToken = "guest_access_token",
                refreshToken = "guest_refresh_token",
                isNewUser = false
            )
        )
    }
}