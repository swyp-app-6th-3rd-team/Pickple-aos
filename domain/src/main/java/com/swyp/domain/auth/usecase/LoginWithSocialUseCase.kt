package com.swyp.domain.auth.usecase

import com.swyp.domain.auth.model.AuthError
import com.swyp.domain.auth.model.AuthProvider
import com.swyp.domain.auth.model.AuthResult
import com.swyp.domain.auth.repository.AuthRepository
import com.swyp.domain.common.result.ResultWrapper
import javax.inject.Inject

class LoginWithSocialUseCase
    @Inject
    constructor(
        private val authRepository: AuthRepository,
    ) {
        suspend operator fun invoke(provider: AuthProvider): ResultWrapper<AuthResult, AuthError> {
            if (provider != AuthProvider.KAKAO && provider != AuthProvider.APPLE) {
                return ResultWrapper.Failure(AuthError.InvalidToken)
            }

            return authRepository.loginWithSocial(provider)
        }
    }
