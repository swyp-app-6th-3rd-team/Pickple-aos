package com.swyp.features.community.post.list

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object PostList : PickpleNavRoute

@Composable
fun PostListRoute(
    onPostDetailClick: () -> Unit,
    onPostWriteClick: () -> Unit,
){
    PostListScreen(
        onPostDetailClick = onPostDetailClick,
        onPostWriteClick = onPostWriteClick
    )
}
