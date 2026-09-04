package com.swyp.core.ui.designsystem.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.swyp.core.ui.designsystem.theme.AppTheme

@Composable
fun TextOnButton(
    text: String,
    modifier:Modifier = Modifier
){
    Text(
        text = text,
        style = AppTheme.typography.body01,
        modifier = modifier
    )
}
