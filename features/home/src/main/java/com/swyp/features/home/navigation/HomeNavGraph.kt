package com.swyp.features.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swyp.core.navigation.PickpleNavRoute
import com.swyp.features.home.main.Home
import com.swyp.features.home.main.HomeRoute
import com.swyp.features.home.ranking.Ranking
import com.swyp.features.home.ranking.RankingRoute
import kotlinx.serialization.Serializable

@Serializable
data object HomeNavGraph : PickpleNavRoute

fun NavGraphBuilder.homeGraph(
    onPostDetailClick: () -> Unit,
    onRankingDetailClick: () -> Unit
) {
    navigation<HomeNavGraph>(
        startDestination = Home
    ){
        composable<Home> {
            HomeRoute(
                onPostDetailClick = onPostDetailClick,
                onRankingDetailClick = onRankingDetailClick
            )
        }
        composable<Ranking> {
            RankingRoute()
        }
    }
}
