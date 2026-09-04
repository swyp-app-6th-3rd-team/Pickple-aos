package com.swyp.core.ui.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.swyp.core.ui.designsystem.theme.colors.AppColors
import com.swyp.core.ui.designsystem.theme.colors.appAppColors
import com.swyp.core.ui.designsystem.theme.colors.localCoreColors
import com.swyp.core.ui.designsystem.theme.dimens.CoreDimens
import com.swyp.core.ui.designsystem.theme.dimens.localCoreDimens
import com.swyp.core.ui.designsystem.theme.typography.AppTypography
import com.swyp.core.ui.designsystem.theme.typography.localCoreTypography


object AppTheme {
    val colors : AppColors
    @ReadOnlyComposable
    @Composable
    get() = localCoreColors.current

    val typography : AppTypography
    @ReadOnlyComposable
    @Composable
    get() = localCoreTypography.current

    val dimens : CoreDimens
    @ReadOnlyComposable
    @Composable
    get() = localCoreDimens.current
}

@Composable
fun PickpleTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        localCoreColors provides appAppColors,
        localCoreTypography provides AppTypography,
    ) {
        MaterialTheme(
            content = content
        )
    }
}