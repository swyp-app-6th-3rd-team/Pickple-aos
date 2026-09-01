package com.swyp.pickple.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.swyp.features.community.navigation.communityNavGraph
import com.swyp.features.community.post.detail.PostDetail
import com.swyp.features.home.navigation.homeGraph
import com.swyp.features.home.ranking.Ranking
import com.swyp.features.mypage.navigation.myPageGraph
import com.swyp.features.onboarding.ui.navigation.onboardingNavGraph
import com.swyp.features.onboarding.ui.profile.Profile
import com.swyp.pickple.ui.NavigationTestPage


@Composable
internal fun AppNavHost(
    paddingValues: PaddingValues,
    navController: NavHostController = rememberNavController()
) {

    val startDestination = NavigationTestPage

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding())
            .fillMaxSize()
    ) {
        composable<NavigationTestPage> { NavigationTestPage(navController = navController ) }

        onboardingNavGraph()
        homeGraph(
            onPostDetailClick = { navController.navigate(PostDetail) },
            onRankingDetailClick = { navController.navigate(Ranking) }
        )
        communityNavGraph(
            navController = navController
        )
        myPageGraph(
            onProfileClick = { navController.navigate(Profile) },
            navController = navController
        )
    }
}