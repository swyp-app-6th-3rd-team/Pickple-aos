package com.swyp.domain.auth.repository

import com.swyp.domain.auth.model.AuthError
import com.swyp.domain.auth.model.AuthProvider
import com.swyp.domain.auth.model.AuthResult
import com.swyp.domain.common.ResultWrapper


interface AuthRepository {
    suspend fun loginWithSocial(provider: AuthProvider): ResultWrapper<AuthResult, AuthError>
    suspend fun loginAsGuest(): ResultWrapper<AuthResult, AuthError>
}