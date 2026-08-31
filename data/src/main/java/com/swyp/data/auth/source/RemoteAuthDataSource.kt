package com.swyp.data.auth.source

import com.swyp.domain.auth.model.AuthError
import com.swyp.domain.auth.model.AuthProvider
import com.swyp.domain.auth.model.AuthResult
import com.swyp.domain.common.result.ResultWrapper

interface RemoteAuthDataSource {
    suspend fun login(
        provider: AuthProvider,
        providerToken: String,
    ): ResultWrapper<AuthResult, AuthError>

    suspend fun loginAsGuest(): ResultWrapper<AuthResult, AuthError>
}
