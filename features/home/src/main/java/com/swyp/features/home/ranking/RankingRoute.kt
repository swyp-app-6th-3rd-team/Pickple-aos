package com.swyp.features.home.ranking

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object Ranking : PickpleNavRoute

@Composable
fun RankingRoute(

){
    RankingScreen()
}