@file:Suppress("detekt:all", "ktlint")

package com.swyp.pickple.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.swyp.core.navigation.PageNavRoute
import com.swyp.core.navigation.PickpleNavSuper


data class RouteItem (
    val title: String,
    val route: PickpleNavSuper
)


@Composable
fun NavigationTestPage(
    onRouteClick: (PickpleNavSuper) -> Unit = {}
){
    val items = listOf(
        RouteItem("onboarding", PageNavRoute.Onboarding),
        RouteItem("community", PageNavRoute.Community),
        RouteItem("mypage", PageNavRoute.MyPage),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            Card(
                onClick = {onRouteClick(item.route)},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.title,
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}