@file:Suppress("detekt:all", "ktlint")

package com.swyp.features.home.main

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.swyp.core.ui.component.TestButton

@Composable
fun HomeScreen(
    onPostDetailClick: () -> Unit = {},
    onRankingDetailClick: () -> Unit = {}
){
    Column {
        TestButton(
            onPostDetailClick,
            "home page",
            "post detail"
        )
        TestButton(
            onRankingDetailClick,
            text = "Ranking detail"
        )
    }
}