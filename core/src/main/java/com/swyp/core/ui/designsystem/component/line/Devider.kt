package com.swyp.core.ui.designsystem.component.line

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.swyp.core.ui.designsystem.theme.AppTheme


@Composable
fun Divider(
    color: Color = AppTheme.colors.border,
    thickness : Dp = 1.dp,
    modifier: Modifier = Modifier.padding(horizontal = 14.dp),
) = HorizontalDivider(
    modifier = modifier,
    thickness = thickness,
    color = color
)