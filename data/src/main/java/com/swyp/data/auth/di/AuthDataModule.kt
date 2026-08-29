package com.swyp.data.auth.di

import com.swyp.data.auth.di.qualifier.AppleAuth
import com.swyp.data.auth.di.qualifier.KakaoAuth
import com.swyp.data.auth.repository.impl.AuthRepositoryImpl
import com.swyp.data.auth.source.SocialAuthDataSource
import com.swyp.data.auth.source.impl.AppleAuthDataSourceImpl
import com.swyp.data.auth.source.impl.KakaoAuthDataSourceImpl
import com.swyp.domain.auth.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AuthDataModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    @KakaoAuth
    abstract fun bindKakaoAuthDataSource(
        kakaoAuthDataSourceImpl: KakaoAuthDataSourceImpl
    ): SocialAuthDataSource

    @Binds
    @Singleton
    @AppleAuth
    abstract fun bindAppleAuthDataSource(
        appleAuthDataSourceImpl: AppleAuthDataSourceImpl
    ): SocialAuthDataSource
}