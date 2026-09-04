package com.swyp.core.ui.designsystem.component.selection

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.swyp.core.R
import com.swyp.core.ui.designsystem.component.extensions.blackOrWhite
import com.swyp.core.ui.designsystem.component.extensions.borderColor
import com.swyp.core.ui.designsystem.theme.colors.White
import com.swyp.core.ui.designsystem.util.PreviewBase
import com.swyp.core.ui.designsystem.util.PreviewOnSize

@Composable
fun AppCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier
) {
    val backgroundColor by animateColorAsState(
        targetValue = checked.blackOrWhite,
        label = "checkbox_bg_color"
    )
    val borderColor by animateColorAsState(
        targetValue = checked.borderColor, // 추후 정확한 색상이(D9D9D9) 필요하다면 변경 될 수 있음
        label = "checkbox_border_color"
    )
    Box(
        modifier = modifier
            .size(20.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(backgroundColor)
            .border(1.dp, borderColor, RoundedCornerShape(4.dp))
            .then(
                // 읽기 전용 상태가 아닐 때만 토글 액션 부여
                onCheckedChange?.let {
                    Modifier.toggleable(
                        value = checked,
                        onValueChange = it,
                        role = Role.Checkbox
                    )
                } ?: Modifier
            ),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_check),
                contentDescription = null, // Role이 있으므로 null
                tint = White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@PreviewOnSize
@Composable
fun AppCheckboxPreview() {

    var isChecked by remember { mutableStateOf(false) }

        PreviewBase {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .toggleable(
                            value = isChecked,
                            onValueChange = { isChecked = it },
                            role = Role.Checkbox
                        )
                        .padding(vertical = 12.dp), // 터치 영역 확보
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppCheckbox(
                        checked = isChecked,
                        onCheckedChange = null // Row에서 이벤트를 가져갔으므로 null 처리
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "약관에 동의합니다",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                AppCheckbox(
                    checked = false,
                    onCheckedChange = null,
                )
                AppCheckbox(
                    checked = true,
                    onCheckedChange = null,
                )
        }
}
