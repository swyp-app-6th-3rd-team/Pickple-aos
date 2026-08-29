package com.swyp.data.auth.source

interface SocialAuthDataSource {
    suspend fun login(): Result<String>
}