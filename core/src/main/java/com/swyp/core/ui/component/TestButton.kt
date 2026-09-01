@file:Suppress("detekt:all", "ktlint")
package com.swyp.core.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TestButton (
    onRouteClick : () -> Unit,
    pageName : String = "",
    text : String = ""
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(pageName, modifier = Modifier.padding(bottom = 20.dp))
        Card(
            onClick = onRouteClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}