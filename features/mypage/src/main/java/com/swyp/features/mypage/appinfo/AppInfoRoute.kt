package com.swyp.features.mypage.appinfo

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object AppInfo : PickpleNavRoute

@Composable
fun AppInfoRoute(
){
    AppInfoScreen(
    )
}