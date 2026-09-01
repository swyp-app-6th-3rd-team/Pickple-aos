package com.swyp.features.community.post.write

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object PostWrite : PickpleNavRoute

@Composable
fun PostWriteRoute(){
    PostWriteScreen()
}