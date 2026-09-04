package com.swyp.core.ui.designsystem.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.swyp.core.ui.designsystem.component.text.TextOnButton
import com.swyp.core.ui.designsystem.theme.AppTheme
import com.swyp.core.ui.designsystem.util.PreviewBase
import com.swyp.core.ui.designsystem.util.PreviewOnSize


private val buttonHeight = 56.dp

// 텍스트용
@Composable
fun ActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppTheme.colors.primaryBtn,
    contentColor: Color = AppTheme.colors.primaryBtnContent,
    contentPadding: PaddingValues = PaddingValues(horizontal = AppTheme.dimens.buttonContentPadding),
    borderStroke: BorderStroke? = null,
    text: String
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(buttonHeight),
        shape = RoundedCornerShape(AppTheme.dimens.defaultShape),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        border = borderStroke,
        contentPadding = contentPadding
    ) {
        TextOnButton(text = text)
    }
}
// 슬롯 api 용
@Composable
fun ActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppTheme.colors.primaryBtn,
    contentColor: Color = AppTheme.colors.primaryBtnContent,
    contentPadding: PaddingValues = PaddingValues(horizontal = AppTheme.dimens.buttonContentPadding),
    border: BorderStroke? = null,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(buttonHeight),
        shape = RoundedCornerShape(AppTheme.dimens.defaultShape),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        border = border,
        contentPadding = contentPadding
    ) {
        content()
    }
}

@PreviewOnSize
@Composable
fun ActionButtonPreview(){
    PreviewBase {
        ActionButton(
            onClick = {},
            text = "확인"
        )
    }
}