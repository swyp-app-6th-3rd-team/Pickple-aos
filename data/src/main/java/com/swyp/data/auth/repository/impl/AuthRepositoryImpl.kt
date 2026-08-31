package com.swyp.data.auth.repository.impl

import com.swyp.data.auth.di.qualifier.AppleAuth
import com.swyp.data.auth.di.qualifier.KakaoAuth
import com.swyp.data.auth.source.RemoteAuthDataSource
import com.swyp.data.auth.source.SocialAuthDataSource
import com.swyp.domain.auth.model.AuthError
import com.swyp.domain.auth.model.AuthProvider
import com.swyp.domain.auth.model.AuthResult
import com.swyp.domain.auth.repository.AuthRepository
import com.swyp.domain.common.result.ResultWrapper
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    @KakaoAuth private val kakaoAuthDataSource: SocialAuthDataSource,
    @AppleAuth private val appleAuthDataSource: SocialAuthDataSource,
    private val remoteAuthDataSource: RemoteAuthDataSource,
) : AuthRepository {

    override suspend fun loginWithSocial(
        provider: AuthProvider,
    ): ResultWrapper<AuthResult, AuthError> {


        val socialToken = when (provider) {
            AuthProvider.KAKAO ->
                kakaoAuthDataSource.login()

            AuthProvider.APPLE ->
                appleAuthDataSource.login()
        }

        val providerToken = socialToken.getOrElse { exception ->
            return ResultWrapper.Failure(
                exception.toAuthError()
            )
        }

        return remoteAuthDataSource.login(
            provider = provider,
            providerToken = providerToken,
        )
    }

    override suspend fun loginAsGuest(): ResultWrapper<AuthResult, AuthError> {
        return remoteAuthDataSource.loginAsGuest()
    }
}

private fun Throwable.toAuthError(): AuthError {
    return when (this) {
        else -> AuthError.Unknown(message)
    }
}