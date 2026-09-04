package com.swyp.core.ui.designsystem.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.swyp.core.ui.designsystem.theme.AppTheme
import com.swyp.core.ui.designsystem.theme.colors.Black
import com.swyp.core.ui.designsystem.theme.colors.White
import com.swyp.core.ui.designsystem.util.PreviewBase
import com.swyp.core.ui.designsystem.util.PreviewOnSize

@Composable
fun AppChip(
    text: String,
    modifier: Modifier = Modifier,
    variant: ChipVariant = ChipVariant.DARK,
    leadingIcon: (@Composable () -> Unit)? = null
) {
    //색상 매핑
    val chipColors = variant.style

    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(chipColors.container)
            .then(chipColors.border)
            .padding(horizontal = 10.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // 좌측 아이콘 있을 때에만 렌더링
        leadingIcon?.invoke()
        // 텍스트
        Text(
            text = text,
            color = chipColors.content,
            style = AppTheme.typography.label
        )
    }
}

// 칩 스타일 유형
enum class ChipVariant {
    DARK,       // 검은색 바탕, 흰색 글씨
    OUTLINED,   // 흰색 바탕, 회색 테두리
    TRANSLUCENT // 반투명 바탕, 흰색 글씨
}

// 침 디자인 스타일
data class ChipStyle(
    val container: Color,
    val content: Color,
    val border: Modifier,
)

private val ChipVariant.style: ChipStyle
    @ReadOnlyComposable
    @Composable
    get() = when (this) {
        ChipVariant.DARK -> ChipStyle(
            container = Black,
            content = Color.White,
            border = Modifier,
        )

        ChipVariant.OUTLINED -> ChipStyle(
            container = White,
            content = AppTheme.colors.textSecondary,
            border = Modifier.border(1.dp, AppTheme.colors.border, CircleShape)
        )

        ChipVariant.TRANSLUCENT -> ChipStyle(
            container = Black.copy(alpha = 0.4f),
            content = Color.White,
            border = Modifier,
        )
    }

@PreviewOnSize
@Composable
fun AppChipPreview() {
    PreviewBase {
        AppChip(
            text = "찬반",
            variant = ChipVariant.DARK,
            leadingIcon = {
                Text("👍")
            }
        )
        AppChip(
            text = "찬반",
            variant = ChipVariant.OUTLINED,
            leadingIcon = {
                Text("👍")
            }
        )
        AppChip(
            text = "1/3",
            variant = ChipVariant.TRANSLUCENT
        )
    }
}

