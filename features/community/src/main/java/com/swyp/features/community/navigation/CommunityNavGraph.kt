package com.swyp.features.community.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.swyp.core.navigation.PickpleNavRoute
import com.swyp.features.community.post.detail.PostDetail
import com.swyp.features.community.post.detail.PostDetailRoute
import com.swyp.features.community.post.list.PostList
import com.swyp.features.community.post.list.PostListRoute
import com.swyp.features.community.post.write.PostWrite
import com.swyp.features.community.post.write.PostWriteRoute
import kotlinx.serialization.Serializable

@Serializable
data object CommunityNavGraph : PickpleNavRoute

fun NavGraphBuilder.communityNavGraph(
    navController: NavHostController,
){
    navigation<CommunityNavGraph>(
        startDestination = PostList
    ){
        composable<PostList>{
            PostListRoute(
                onPostDetailClick = { navController.navigate(PostDetail) },
                onPostWriteClick = { navController.navigate(PostWrite) }
            )
        }
        composable<PostDetail>{ PostDetailRoute() }
        composable<PostWrite>{ PostWriteRoute() }
    }
}
