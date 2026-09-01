package com.swyp.features.mypage.account

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object Account : PickpleNavRoute

@Composable
fun AccountRoute(
){
    AccountScreen(
    )
}