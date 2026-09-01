package com.swyp.features.community.post.list

import androidx.compose.runtime.Composable
import com.swyp.core.ui.component.TestButton

@Composable
fun PostListScreen(
    onPostDetailClick: () -> Unit,
    onPostWriteClick: () -> Unit,
){
   TestButton(
       onRouteClick = onPostDetailClick,
       pageName = "Post List",
       text = "Post Detail"
   )
   TestButton(
       onRouteClick = onPostWriteClick,
       pageName = "Post List",
       text = "Post Write"
   )
}