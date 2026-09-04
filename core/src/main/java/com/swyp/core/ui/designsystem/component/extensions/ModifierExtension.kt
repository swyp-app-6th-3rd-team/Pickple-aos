package com.swyp.core.ui.designsystem.component.extensions

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp

// 레이아웃을 벗어 난 자식 영역에게 부여할 (- dp) 계산 함수
fun Modifier.horizontalBleed(amount: Dp) = this.layout { measurable, constraints ->
    val overflowPx = (amount * 2).roundToPx()
    val placeable = measurable.measure(constraints.copy(maxWidth = constraints.maxWidth + overflowPx))
    layout(placeable.width, placeable.height) {
        placeable.place(x = -amount.roundToPx(), y = 0)
    }
}