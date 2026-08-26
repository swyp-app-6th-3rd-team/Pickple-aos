package com.swyp.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface PageNavRoute : PickpleNavSuper {

    @Serializable
    data object Home : PickpleNavSuper

    @Serializable
    data object Community : PickpleNavSuper

    @Serializable
    data object MyPage : PickpleNavSuper

    @Serializable
    data object Onboarding : PickpleNavSuper
}