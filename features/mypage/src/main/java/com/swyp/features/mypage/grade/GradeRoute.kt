package com.swyp.features.mypage.grade

import androidx.compose.runtime.Composable
import com.swyp.core.navigation.PickpleNavRoute
import kotlinx.serialization.Serializable

@Serializable
data object Grade : PickpleNavRoute

@Composable
fun GradeRoute(
){
    GradeScreen(
    )
}