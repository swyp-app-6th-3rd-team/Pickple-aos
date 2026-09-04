package com.swyp.core.ui.designsystem.component.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StopScreenShare
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
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swyp.core.ui.designsystem.component.extensions.TextState
import com.swyp.core.ui.designsystem.component.extensions.borderColor
import com.swyp.core.ui.designsystem.component.extensions.color
import com.swyp.core.ui.designsystem.theme.AppTheme
import com.swyp.core.ui.designsystem.theme.colors.Black
import com.swyp.core.ui.designsystem.util.PreviewBase

/*
Todo : 불륨에 따라 수정 가능 성 있음
  (1) 포커스 책임
    → root에 주는 경우
    → focusRequester를 사용하는 경우
  (2) 상태 관리
    → InteractionSource를 사용하여 포커스 상태를 감지
    → `mutableStateOf` 감지
  Check : State 변화에 애니메이션적 요소, 타이핑 시 State 체크
 */

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    state: TextState = TextState.NORMAL,
    description: String? = null,
    trailingContent: (@Composable () -> Unit)? = null
) {
    var isFocused by remember { mutableStateOf(false) }

    val borderColor = state.color ?: isFocused.borderColor
    val descriptionColor = state.color ?: AppTheme.colors.textTertiary

    Column(modifier = modifier.fillMaxWidth()) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(1.dp, borderColor, RoundedCornerShape(AppTheme.dimens.defaultShape))
                .padding(horizontal = 20.dp, vertical = 15.dp)
                .onFocusChanged { isFocused = it.isFocused },
            textStyle = AppTheme.typography.body01,
            cursorBrush = SolidColor(Black),
            singleLine = true,
            decorationBox = { innerTextField ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = AppTheme.typography.body01,
                                color = AppTheme.colors.textSecondary
                            )
                        }
                        innerTextField()
                    }
                    //  우측 content (trailingContent가 null이 아닐 때만 렌더링)
                    trailingContent?.invoke()
                }
            }
        )

        // 하단 설명 텍스트 (description이 null이 아닐 때만 렌더링)
        description?.let{
            Text(
                text = description,
                color = descriptionColor,
                style = AppTheme.typography.labelMedium,
                modifier = Modifier.padding(top = 4.dp, start = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun TextFieldPreview() {
    val focusManager = LocalFocusManager.current

    PreviewBase(
        modifier = Modifier.focusTarget()
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            }
    ){

        // 1. 기본 입력
        var text1 by remember { mutableStateOf("") }
        Text("1. 기본 입력 (Hint)")
        TextField(
            value = text1,
            onValueChange = { text1 = it },
            placeholder = "내용을 입력해주세요"
        )

        // 2. 우측 텍스트 포함
        var text2 by remember { mutableStateOf("Pickple") }
        Text("2. 우측 텍스트 포함")
        TextField(
            value = text2,
            onValueChange = { text2 = it },
            trailingContent = {
                Text(
                    text = "${text2.length}/30",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFFAAAAAA))
                )
            }
        )

        // 3. 우측 아이콘 포함
        var text3 by remember { mutableStateOf("") }
        Text("3. 우측 아이콘 포함")
        TextField(
            value = text3,
            onValueChange = { text3 = it },
            placeholder = "검색어를 입력하세요",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.StopScreenShare,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }
        )

        // 4. 일반 Description 상태
        var text4 by remember { mutableStateOf("") }
        Text("4. 일반 Description 상태")
        TextField(
            value = text4,
            onValueChange = { text4 = it },
            placeholder = "Text",
            state = TextState.NORMAL,
            description = "Description"
        )

        // 5. Error 상태
        var text5 by remember { mutableStateOf("") }
        Text("5. Error 상태")
        TextField(
            value = text5,
            onValueChange = { text5 = it },
            placeholder = "Text",
            state = TextState.ERROR,
            description = "Error"
        )

        // 6. Success 상태
        var text6 by remember { mutableStateOf("") }
        Text(" 6. Success 상태")
        TextField(
            value = text6,
            onValueChange = { text6 = it },
            placeholder = "Text",
            state = TextState.SUCCESS,
            description = "Success"
        )

    }
}


