
package com.swyp.features.community.post.detail

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object PostDetail : PickpleNavRoute

@Composable
fun PostDetailRoute(

){
    PostDetailScreen()
}