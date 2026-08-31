package com.swyp.data.auth.source.impl

import com.swyp.data.auth.source.RemoteAuthDataSource
import com.swyp.domain.auth.model.AuthError
import com.swyp.domain.auth.model.AuthProvider
import com.swyp.domain.auth.model.AuthResult
import com.swyp.domain.common.result.ResultWrapper
import timber.log.Timber
import javax.inject.Inject

class RemoteAuthDataSourceImpl @Inject constructor() : RemoteAuthDataSource {

    override suspend fun login(
        provider: AuthProvider,
        providerToken: String,
    ): ResultWrapper<AuthResult, AuthError> {

        Timber.d("서버 로그인 Request: provider=$provider, token=$providerToken...")

        return ResultWrapper.Success(
            AuthResult(
                accessToken = "dummy_access_token",
                refreshToken = "dummy_refresh_token",
                isNewUser = true,
            )
        )
    }

    override suspend fun loginAsGuest(): ResultWrapper<AuthResult, AuthError> {
        return ResultWrapper.Success(
            AuthResult(
                accessToken = "guest_access_token",
                refreshToken = "guest_refresh_token",
                isNewUser = false,
            )
        )
    }
}