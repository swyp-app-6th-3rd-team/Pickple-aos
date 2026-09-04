package com.swyp.core.ui.designsystem.component.selection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.swyp.core.ui.designsystem.component.line.Divider
import com.swyp.core.ui.designsystem.theme.AppTheme
import com.swyp.core.ui.designsystem.util.PreviewBase
import com.swyp.core.ui.designsystem.util.PreviewOnSize

@Composable
fun AppTabBar(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    tabColor: Color = AppTheme.colors.primary,
    isDark : Boolean = false,
) {
    PrimaryTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier.fillMaxWidth(),
        containerColor = Color.Unspecified,
        indicator = {
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(selectedTabIndex),
                color = tabColor,
                height = 2.dp
            )
        },
        divider = {Divider()}
    ) {
        tabs.forEachIndexed { index, title ->
            val isSelected = selectedTabIndex == index
            val textColor = AppTabBarTextColor(isDark, isSelected)

            Tab(
                selected = isSelected,
                onClick = { onTabSelected(index) },
                modifier = Modifier.height(48.dp)
            ) {
                Text(
                    text = title,
                    style = isSelected.selectedStyle,
                    color = textColor
                )
            }
        }
    }
}

private val Boolean.selectedStyle: TextStyle
    @ReadOnlyComposable
    @Composable
    get() = if (this) AppTheme.typography.title02.copy(fontWeight = FontWeight.Bold) else
        AppTheme.typography.title02

// 뒷 배경에 따른 text 색 변화
@Composable
@ReadOnlyComposable
private fun AppTabBarTextColor(
    isDark: Boolean,
    isSelected: Boolean,
): Color  = when {
        isDark && isSelected -> AppTheme.colors.darkTabSelectedText
        isDark -> AppTheme.colors.darkTabText
    isSelected -> AppTheme.colors.text
        else -> AppTheme.colors.disabled
    }

@PreviewOnSize
@Composable
fun AppTabBarPreview(){
    val tabs = listOf("tab 1", "tab 2", "tab 3", "tab 4")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    PreviewBase {
        // 1. 뒷 배경이 밝은 경우
        AppTabBar(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = {
                selectedTabIndex = it
            }
        )
        // 2. 뒷 배경이 어두운 경우
        Box(modifier = Modifier.background(color = Color.Black)){
            AppTabBar(
                tabs = tabs,
                selectedTabIndex = selectedTabIndex,
                onTabSelected = {
                    selectedTabIndex = it
                },
                isDark = true
            )
        }
    }
}