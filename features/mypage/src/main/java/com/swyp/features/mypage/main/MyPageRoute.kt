package com.swyp.features.mypage.main

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object MyPage : PickpleNavRoute

@Composable
fun MyPageRoute(
    onProfileClick: () -> Unit,
    onActivityHistoryClick: () -> Unit,
    onAccountClick: () -> Unit,
    onGradeClick: () -> Unit,
    onAppInfoClick: () -> Unit,
){
    MyPageScreen(
        onProfileClick = onProfileClick,
        onActivityHistoryClick = onActivityHistoryClick,
        onAccountClick = onAccountClick,
        onGradeClick = onGradeClick,
        onAppInfoClick = onAppInfoClick
    )
}