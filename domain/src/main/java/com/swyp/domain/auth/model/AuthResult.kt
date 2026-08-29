package com.swyp.domain.auth.model

data class AuthResult(
    val accessToken: String,
    val refreshToken: String,
    val isNewUser: Boolean
)