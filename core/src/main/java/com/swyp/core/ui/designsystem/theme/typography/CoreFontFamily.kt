package com.swyp.core.ui.designsystem.theme.typography

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.swyp.core.R

val Pretendard = FontFamily(
    Font(
        resId = R.font.pretendard_regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resId = R.font.pretendard_medium,
        weight = FontWeight.Medium,
    ),
    Font(
        resId = R.font.pretendard_semibold,
        weight = FontWeight.SemiBold,
    ),
    Font(
        resId = R.font.pretendard_bold,
        weight = FontWeight.Bold,
    ),
)