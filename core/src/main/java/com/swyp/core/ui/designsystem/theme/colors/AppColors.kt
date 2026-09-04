@file:Suppress("MagicNumber")
package com.swyp.core.ui.designsystem.theme.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    // Brand
    val primary: Color,
    val secondary: Color,
    // Text
    val text: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    // Background
    val background: Color,
    // Line
    val border: Color,
    val borderSecondary: Color,
    val enabled: Color,
    // Surface
    val surface: Color,
    // Disabled
    val disabled: Color,
    // State
    val info: Color,
    val infoContainer: Color,
    val error: Color,
    val success: Color,
    // Accent
    val accentPrimary: Color,
    val accentBrand: Color,
    // button
    val primaryBtn : Color,
    val primaryBtnContent : Color,
    val secondaryBtn : Color,
    val secondaryBtnContent : Color,
    // tab
    val darkTabText : Color,
    val darkTabSelectedText : Color,
)

val appAppColors = AppColors(
    // Brand
    primary = PrimaryColor60,
    secondary = Secondary60,
    // Text
    text = Neutral100,
    textSecondary = Neutral40,
    textTertiary = Neutral30,
    error = Red60,
    success = Green60,
    //Background
    background = White,
    //Line
    border = Secondary10,
    borderSecondary = Color(0xFFE4E4E4),
    enabled = Secondary60,
    // surface
    surface = Secondary10,
    // 비활성화
    disabled = Neutral20,
    // 상태 색상
    info = Neutral70,
    infoContainer = White,
    //accent
    accentPrimary = Blue60,
    accentBrand = PrimaryColor90,
    // button
    primaryBtn = Black,
    primaryBtnContent = White,
    secondaryBtn = Color(0xFFF1F1F5),
    secondaryBtnContent = Neutral50,
    // tab
    darkTabText = Color(0xFF999999),
    darkTabSelectedText = Color(0xFFFEFEFE),
)

val localCoreColors = staticCompositionLocalOf { appAppColors }
