package com.swyp.domain.auth.usecase

import javax.inject.Inject

data class AuthUseCase
    @Inject
    constructor(
        val loginWithSocialUseCase: LoginWithSocialUseCase,
    )
