package com.swyp.pickple.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.swyp.core.navigation.PageNavRoute.Community
import com.swyp.core.navigation.PageNavRoute.Home
import com.swyp.core.navigation.PageNavRoute.MyPage
import com.swyp.core.navigation.PageNavRoute.Onboarding
import com.swyp.features.community.ui.CommunityScreen
import com.swyp.features.mypage.MypageScreen
import com.swyp.features.onboarding.ui.OnboardingScreen
import com.swyp.pickple.ui.NavigationTestPage

fun NavGraphBuilder.customNavGraphBuilder(
    navController: NavController,
) {
    composable<Home> { NavigationTestPage(
        onRouteClick = { route ->
            navController.navigate(route)
        }
    ) }
    composable<MyPage> { MypageScreen() }
    composable<Community> { CommunityScreen() }
    composable<Onboarding> { OnboardingScreen() }

}