package com.swyp.features.onboarding.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swyp.core.navigation.PickpleNavRoute
import com.swyp.features.onboarding.ui.profile.Profile
import com.swyp.features.onboarding.ui.profile.ProfileRoute
import kotlinx.serialization.Serializable


@Serializable
data object OnboardingGraph : PickpleNavRoute

fun NavGraphBuilder.onboardingNavGraph(
){
    navigation<OnboardingGraph>(
        startDestination = Profile
    ){
        composable<Profile>{
            ProfileRoute(
            )
        }
    }
}
