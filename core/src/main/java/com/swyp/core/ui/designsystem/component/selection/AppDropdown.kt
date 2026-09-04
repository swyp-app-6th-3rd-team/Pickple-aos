package com.swyp.core.ui.designsystem.component.selection

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.swyp.core.R
import com.swyp.core.ui.designsystem.component.line.Divider
import com.swyp.core.ui.designsystem.theme.AppTheme
import com.swyp.core.ui.designsystem.theme.colors.Neutral40
import com.swyp.core.ui.designsystem.theme.colors.Neutral80
import com.swyp.core.ui.designsystem.theme.colors.White
import com.swyp.core.ui.designsystem.util.PreviewBase
import com.swyp.core.ui.designsystem.util.PreviewOnSize

@Composable
fun AppDropdown(
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "카테고리를 선택해주세요"
) {
    var expanded by remember { mutableStateOf(false) }
    var dropDownWidth by remember { mutableIntStateOf(0) }

    val openedBorderColor = AppTheme.colors.borderSecondary

    Box(
        modifier = modifier
            .fillMaxWidth()
            .onSizeChanged { dropDownWidth = it.width }
    ) {
        // 닫혀있을 때의 기본 앵커
            DropdownAnchor(
                expanded = expanded,
                placeholder = placeholder,
                selectedOption = selectedOption,
                onClick = { expanded = true }
            )
        // 펼쳤을 때
        if (expanded) {
            Popup(
                alignment = Alignment.TopStart,
                onDismissRequest = { expanded = false }
            ) {
                Column(
                    modifier = Modifier
                        .width(with(LocalDensity.current) { dropDownWidth.toDp() })
                        .clip(RoundedCornerShape(AppTheme.dimens.defaultShape))
                        .border(1.dp, openedBorderColor, RoundedCornerShape(AppTheme.dimens.defaultShape))
                        .background(White)
                ) {
                    // 팝업 내부의 최상단 앵커 (클릭 시 팝업 닫힘)
                    DropdownAnchor(
                        expanded = true,
                        placeholder = placeholder,
                        selectedOption = selectedOption,
                        onClick = { expanded = false }
                    )
                    // 구분선
                    Divider()
                    // 메뉴 리스트
                    options.forEachIndexed { index, option ->
                        DropdownOption(
                            option = option,
                            onClick = {
                                onOptionSelected(option)
                                expanded = false
                            }
                        )
                        // 마지막 아이템을 제외한 하단 구분선
                        if (index < options.lastIndex) {
                            Divider(openedBorderColor)
                        }
                    }
                }
            }
        }
    }
}



@Composable
private fun DropdownOption(
    option: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .clickable {onClick()}
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = option,
            style = AppTheme.typography.body01,
            color = Neutral80
        )
    }
}

@Composable
private fun DropdownAnchor(
    expanded: Boolean,
    placeholder: String,
    selectedOption: String?,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(AppTheme.dimens.defaultShape))
            .border(1.dp, AppTheme.colors.border, RoundedCornerShape(AppTheme.dimens.defaultShape))
            .background(White)
    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val isSelected = (selectedOption != null)

        Text(
            text = selectedOption ?: placeholder,
            style = isSelected.selectedStyle,
            color = isSelected.selectedColor,
            modifier = Modifier.weight(1f),
        )

        Icon(
            imageVector = ImageVector.vectorResource(expanded.selectedIcon),
            contentDescription = "dropdown arrow",
            tint = Neutral40,
            modifier = Modifier.size(24.dp)
        )
    }}
}

private val Boolean.selectedColor: Color
    @ReadOnlyComposable
    @Composable
    get() = if (this) Neutral80 else AppTheme.colors.textSecondary

private val Boolean.selectedStyle: TextStyle
    @ReadOnlyComposable
    @Composable
    get() = if (this) AppTheme.typography.body01.copy(fontWeight = FontWeight.Bold) else
        AppTheme.typography.body01

private val Boolean.selectedIcon : Int
    get() = if (this) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down

@PreviewOnSize
@Composable
fun AppDropdownPreview() {
    val categories  = listOf(
        "패션/잡화",
        "전자제품",
        "화장품/뷰티",
        "생활용품",
        "기타"
    )
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    PreviewBase{
        AppDropdown(
            options = categories,
            selectedOption = selectedCategory,
            onOptionSelected = { selectedCategory = it },
            placeholder = "카테고리를 선택해주세요"
        )
    }
}
