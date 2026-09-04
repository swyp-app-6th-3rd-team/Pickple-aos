package com.swyp.core.ui.designsystem.component.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import com.swyp.core.ui.designsystem.theme.AppTheme
import com.swyp.core.ui.designsystem.theme.colors.Black
import com.swyp.core.ui.designsystem.theme.colors.White

val Boolean.borderColor: Color
    @ReadOnlyComposable
    @Composable
    get() = if (this) Black else AppTheme.colors.border

val Boolean.blackOrWhite: Color
    @ReadOnlyComposable
    @Composable
    get() = if (this) Black else White

// 텍스트 상태에 따른 색 지정
enum class TextState {
    NORMAL, ERROR, SUCCESS
}

val TextState.color: Color?
    @Composable
    get() = when (this) {
        TextState.NORMAL -> null
        TextState.ERROR -> AppTheme.colors.error
        TextState.SUCCESS -> AppTheme.colors.success
    }