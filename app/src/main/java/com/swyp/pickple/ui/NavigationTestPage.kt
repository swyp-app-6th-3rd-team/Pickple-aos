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
import androidx.navigation.NavHostController
import com.swyp.core.navigation.PickpleNavRoute
import com.swyp.features.community.navigation.CommunityNavGraph
import com.swyp.features.home.navigation.HomeNavGraph
import com.swyp.features.mypage.navigation.MyPageNavGraph
import com.swyp.features.onboarding.ui.navigation.OnboardingGraph
import kotlinx.serialization.Serializable


data class RouteItem (
    val title: String,
    val route: PickpleNavRoute
)

@Serializable
data object NavigationTestPage : PickpleNavRoute


@Composable
fun NavigationTestPage(
    navController: NavHostController,
){
    val items = listOf(
        RouteItem("onboarding", OnboardingGraph),
        RouteItem("community", CommunityNavGraph),
        RouteItem("mypage", MyPageNavGraph),
        RouteItem("home", HomeNavGraph),
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
                onClick = {navController.navigate(route = item.route)},
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