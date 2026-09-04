package com.swyp.core.ui.designsystem.component.overlay

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.swyp.core.ui.designsystem.component.button.ActionButton
import com.swyp.core.ui.designsystem.component.button.DoubleButton
import com.swyp.core.ui.designsystem.component.card.AppCard
import com.swyp.core.ui.designsystem.theme.AppTheme
import com.swyp.core.ui.designsystem.theme.colors.Neutral70
import com.swyp.core.ui.designsystem.util.PreviewBase
import com.swyp.core.ui.designsystem.util.PreviewOnDevice

@Composable
fun AppDialog(
    title: String,
    description: String? = null,
    onDismissRequest: () -> Unit,
    button : @Composable () -> Unit = {}
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
    ) {
        AppCard(
            contentPadding = PaddingValues(horizontal = 24.dp),
        ){
            Column(
                modifier = Modifier.padding(top=32.dp, bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                DialogText(title, description)
                button()
            }
        }
    }
}

@Composable
private fun DialogText(
    title: String,
    description: String? = null
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 제목
        Text(
            text = title,
            style = AppTheme.typography.title01,
            color = AppTheme.colors.text,
            textAlign = TextAlign.Center,
        )
        // 보조 설명 텍스트
        description?.let {
            Text(
                text = description,
                style = AppTheme.typography.body01,
                color = Neutral70,
                textAlign = TextAlign.Center
            )
        }
    }
}

@PreviewOnDevice
@Composable
fun AppDialogPreview() {
    var showDialog by remember { mutableStateOf(true) }
    PreviewBase {
        ActionButton(
            onClick = { showDialog = true },
            text = "팝업 다시 열기"
        )
        if (showDialog) {
            AppDialog(
                title = "제목",
                description = "설명",
                onDismissRequest = {
                    showDialog = false
                },
            ) {
                DoubleButton(
                    backBtnText = "이전",
                    submitBtnText = "확인",
                    onBackClick = {
                        showDialog = false
                    },
                    onSubmitClick = {}
                )
            }
        }

    }
}