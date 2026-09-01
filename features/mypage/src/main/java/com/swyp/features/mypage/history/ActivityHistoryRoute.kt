package com.swyp.features.mypage.history

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object ActivityHistory : PickpleNavRoute

@Composable
fun ActivityHistoryRoute(
){
    ActivityHistoryScreen(
    )
}