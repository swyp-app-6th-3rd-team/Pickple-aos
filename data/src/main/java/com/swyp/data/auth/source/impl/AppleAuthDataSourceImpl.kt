package com.swyp.data.auth.source.impl

import com.swyp.data.auth.source.SocialAuthDataSource
import timber.log.Timber
import javax.inject.Inject

class AppleAuthDataSourceImpl @Inject constructor() : SocialAuthDataSource {

    // 테스트를 위한 임시 값
    private companion object {
        const val APPLE_AUTH_URL = "https://appleid.apple.com/auth/authorize"
        const val CLIENT_ID = "com.swyp.pickple.login" // Service ID
        const val REDIRECT_URI = "https://pickple.com/api/auth/apple/callback"
    }

    override suspend fun login(): Result<String> {
        Timber.d("애플 로그인 url : ${buildAppleAuthUrl()}")

        return Result.success("dummy_apple_id_token")
    }

    private fun buildAppleAuthUrl(): String {
        return APPLE_AUTH_URL +
                "?client_id=$CLIENT_ID" +
                "&redirect_uri=$REDIRECT_URI" +
                "&response_type=code id_token" +
                "&scope=name email" +
                "&response_mode=form_post"
    }
}
