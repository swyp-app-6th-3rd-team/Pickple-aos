package com.swyp.data.auth.source.impl

import android.content.Context
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.swyp.data.auth.source.SocialAuthDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.resume

class KakaoAuthDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : SocialAuthDataSource {

    override suspend fun login(): Result<String> =
        suspendCancellableCoroutine { continuation ->
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
                loginWithKakaoTalkApp(context, continuation)
            } else {
                loginWithWebView(context, continuation)
            }
        }

    // 카카오 앱을 통한 로그인 - 실패 시(사용자 취소 제외) 웹뷰 로그인으로 폴백/
    private fun loginWithKakaoTalkApp(
        context: Context,
        continuation: CancellableContinuation<Result<String>>
    ) {
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            when {
                error is ClientError && error.reason == ClientErrorCause.Cancelled -> {
                    continuation.resumeIfActive(Result.failure(error))
                }
                error != null -> {
                    // 카카오톡 앱 로그인 실패(취소 제외) → 웹뷰 로그인으로 재시도
                    loginWithWebView(context, continuation)
                }
                token != null -> {
                    continuation.resumeIfActive(Result.success(token.accessToken))
                }
                else -> {
                    continuation.resumeIfActive(
                        Result.failure(IllegalStateException("카카오 토큰이 존재하지 않습니다."))
                    )
                }
            }
        }
    }

    // 카카오 웹뷰 로그인
    private fun loginWithWebView(
        context: Context,
        continuation: CancellableContinuation<Result<String>>
    ) {
        UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
            when {
                error != null -> {
                    Timber.d("카카오 로그인 실패! ${error.message}")
                    continuation.resumeIfActive(Result.failure(error))
                }
                token != null -> continuation.resumeIfActive(Result.success(token.accessToken))
                else -> continuation.resumeIfActive(
                    Result.failure(IllegalStateException("카카오 토큰이 존재하지 않습니다."))
                )
            }
        }
    }

    private fun <T> CancellableContinuation<T>.resumeIfActive(value: T) {
        if (isActive) resume(value)
    }
}