package com.swyp.core.ui.designsystem.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.swyp.core.ui.designsystem.theme.colors.White
import com.swyp.core.ui.designsystem.util.PreviewBase
import com.swyp.core.ui.designsystem.util.PreviewOnSize

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    contentPadding : PaddingValues = PaddingValues( horizontal = 20.dp, vertical = 16.dp),
    content : @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(White, RoundedCornerShape(16.dp))
            .padding(contentPadding)
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}


@PreviewOnSize
@Composable
fun AppCardPreview(
) {
    PreviewBase(modifier = Modifier.background(Color.Black)) {
     AppCard {
         Text("card")
     }
    }

}