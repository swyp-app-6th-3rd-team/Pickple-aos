@file:Suppress("detekt:all", "ktlint")

package com.swyp.features.mypage.main

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.swyp.core.ui.component.TestButton

@Composable
fun MyPageScreen(
    onProfileClick: () -> Unit,
    onActivityHistoryClick: () -> Unit,
    onAccountClick: () -> Unit,
    onGradeClick: () -> Unit,
    onAppInfoClick: () -> Unit,
){
    Column {
        TestButton(
            onProfileClick,
            "My page",
            "ProfileClick "
        )
        TestButton(
            onActivityHistoryClick,
            text = "ActivityHistoryClick"
        )
        TestButton(
            onAccountClick,
            text = "AccountClick"
        )
        TestButton(
            onGradeClick,
            text = "GradeClick"
        )
        TestButton(
            onAppInfoClick,
            text = "AppInfoClick"
        )
    }
}