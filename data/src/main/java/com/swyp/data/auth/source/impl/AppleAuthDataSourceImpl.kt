package com.swyp.data.auth.source.impl

import com.swyp.data.auth.source.SocialAuthDataSource

class AppleAuthDataSourceImpl : SocialAuthDataSource {
    override suspend fun login(): Result<String> {
        TODO("Not yet implemented")
    }
}