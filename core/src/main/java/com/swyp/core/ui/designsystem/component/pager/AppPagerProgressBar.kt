package com.swyp.core.ui.designsystem.component.pager

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.swyp.core.ui.designsystem.theme.colors.Black
import com.swyp.core.ui.designsystem.theme.colors.Neutral5
import com.swyp.core.ui.designsystem.theme.dimens.PILL_CORNER_RADIUS
import com.swyp.core.ui.designsystem.util.PreviewBase
import com.swyp.core.ui.designsystem.util.PreviewOnSize

@Composable
fun AppPagerProgressBar(
    totalSteps: Int,
    currentStep: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (step in 0..(totalSteps - 1)) {
            val animatedColor by animateColorAsState(
                targetValue = (step <= currentStep).targetColor,
                label = "step_color_anim"
            )
            // 프로세스 바
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(4.dp)
                    .clip(RoundedCornerShape(PILL_CORNER_RADIUS))
                    .background(animatedColor)
            )
        }
    }
}

private val Boolean.targetColor: Color
    get() = if (this) Black else Neutral5

@PreviewOnSize
@Composable
fun AppPagerProgressBarPreview() {
    val pagerState = rememberPagerState(pageCount = { 2 })

    PreviewBase(modifier = Modifier.padding(top = 20.dp)) {
        AppPagerProgressBar(
            totalSteps = pagerState.pageCount,
            currentStep = pagerState.currentPage,
        )

        // 하단 페이저 화면
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> Text("첫번째 페이지")

                1 -> Text("두번째 페이지")
            }
        }
    }
}



