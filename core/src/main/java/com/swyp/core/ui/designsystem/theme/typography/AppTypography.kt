@file:Suppress("MagicNumber")
package com.swyp.core.ui.designsystem.theme.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object AppTypography {

    val heading01 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = leadingPercent(28, 135f),  // 37.8sp
        letterSpacing = trackingPercent(28, -2f) // -0.56sp
    )

    val heading02 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = leadingPercent(24, 140f),
        letterSpacing = trackingPercent(24, -2f)
    )

    val title01 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = leadingPercent(20, 140f),
        letterSpacing = trackingPercent(20, -2f)
    )

    val title02 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.SemiBold,      // 기본 600
        fontSize = 18.sp,
        lineHeight = leadingPercent(18, 145f),
        letterSpacing = trackingPercent(18, -2f)
    )
    val title02Regular = title02.copy(fontWeight = FontWeight.Normal) // 400 variant

    val body01 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,        // 기본 Medium
        fontSize = 16.sp,
        lineHeight = leadingPercent(16, 150f),
        letterSpacing = trackingPercent(16, -2f)
    )
    val body01Regular = body01.copy(fontWeight = FontWeight.Normal)

    val body02 = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = leadingPercent(14, 145f),
        letterSpacing = trackingPercent(14, -2f)
    )
    val body02Regular = body02.copy(fontWeight = FontWeight.Normal)

    val label = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = leadingPercent(13, 140f),
        letterSpacing = trackingPercent(13, -2f)
    )
    val labelMedium =
        label.copy(fontWeight = FontWeight.Medium, lineHeight = leadingPercent(13, 150f))

    val caption = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = leadingPercent(12, 150f),
        letterSpacing = trackingPercent(12, -2f)
    )
    val captionSemiBold = caption.copy(fontWeight = FontWeight.SemiBold)
}

// letter-spacing 헬퍼: CSS -2% 개념을 sp로 자동 환산
private fun trackingPercent(fontSizeSp: Int, percent: Float) =
    (fontSizeSp * percent / 100).sp

// line-height 헬퍼: CSS 135% 개념을 sp로 자동 환산
private fun leadingPercent(fontSizeSp: Int, percent: Float) =
    (fontSizeSp * percent / 100).sp

val localCoreTypography = staticCompositionLocalOf { AppTypography }
