
package com.swyp.features.onboarding.ui.profile

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object Profile : PickpleNavRoute

@Composable
fun ProfileRoute(
){
    ProfileScreen()
}