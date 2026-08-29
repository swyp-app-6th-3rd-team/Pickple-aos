package com.swyp.domain.auth.model

import com.swyp.domain.common.error.DomainError

sealed interface AuthError : DomainError {
    data object InvalidToken : AuthError
    data object NetworkTimeout : AuthError
    data class Unknown(val message: String?) : AuthError
}