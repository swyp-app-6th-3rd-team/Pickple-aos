package com.swyp.core.ui.designsystem.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.swyp.core.ui.designsystem.component.text.TextOnButton
import com.swyp.core.ui.designsystem.theme.AppTheme
import com.swyp.core.ui.designsystem.util.PreviewBase
import com.swyp.core.ui.designsystem.util.PreviewOnSize


@Composable
fun DoubleButton(
    backBtnText: String,
    submitBtnText: String,
    onBackClick: () -> Unit,
    onSubmitClick: () -> Unit
) {
    val buttonHeight = 48.dp

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ActionButton(
            onClick = onBackClick,
            modifier = Modifier
                .weight(1f)
                .height(buttonHeight),
            backgroundColor = AppTheme.colors.secondaryBtn,
            contentColor = AppTheme.colors.secondaryBtnContent
        ) {
            TextOnButton(text = backBtnText)
        }
        ActionButton(
            onClick = onSubmitClick,
            modifier = Modifier
                .weight(1f)
                .height(buttonHeight),
        ) {
            TextOnButton(text = submitBtnText)
        }
    }
}

@PreviewOnSize
@Composable
fun DoubleButtonPreview(){
    PreviewBase{
     DoubleButton(
            backBtnText = "이전",
            submitBtnText = "확인",
            onBackClick = {},
            onSubmitClick = {}
        )
    }
}