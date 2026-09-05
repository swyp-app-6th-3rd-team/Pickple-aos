package com.swyp.core.ui.designsystem.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swyp.core.ui.designsystem.theme.colors.White

const val PREVIEW_DEVICE = Devices.PIXEL_9

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@Preview(
    device = PREVIEW_DEVICE,
    showSystemUi = true
)
annotation class PreviewOnDevice

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@Preview(
    widthDp = 360,
    heightDp = 300,
)
annotation class PreviewOnSize


@Composable
fun PreviewBase(modifier: Modifier = Modifier, content: @Composable () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(White)
            .padding(horizontal = 20.dp)
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
        content()
        }
    }
}