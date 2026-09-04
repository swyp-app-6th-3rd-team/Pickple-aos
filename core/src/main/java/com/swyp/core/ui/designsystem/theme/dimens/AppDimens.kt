@file:Suppress("MagicNumber")
package com.swyp.core.ui.designsystem.theme.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class CoreDimens (
    val defaultShape: Dp = 8.dp,
    val buttonContentPadding: Dp = 16.dp
)

val localCoreDimens = staticCompositionLocalOf { CoreDimens() }
