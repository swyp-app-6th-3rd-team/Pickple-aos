package com.swyp.features.home.main

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object Home : PickpleNavRoute

@Composable
fun HomeRoute(
    onPostDetailClick: () -> Unit = {},
    onRankingDetailClick: () -> Unit = {}
){
    HomeScreen(
        onPostDetailClick = onPostDetailClick,
        onRankingDetailClick = onRankingDetailClick
    )
}