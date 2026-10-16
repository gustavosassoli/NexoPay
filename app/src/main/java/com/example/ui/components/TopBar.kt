package com.example.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.icons.NexoIcons
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoText

@Composable
fun TopBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    showCompactBrand: Boolean = false,
    actionIcon: ImageVector? = null,
    onActionClick: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(47.dp)
            .padding(bottom = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left column (44dp)
        Box(
            modifier = Modifier.width(44.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (onBackClick != null) {
                NexoIconButton(
                    icon = NexoIcons.back,
                    onClick = onBackClick,
                    size = 36.dp,
                    iconSize = 18.dp
                )
            } else if (showCompactBrand) {
                Brand(compact = true)
            }
        }

        // Center column (1fr)
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W600,
                fontSize = 15.sp,
                color = NexoText,
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }

        // Right column (44dp)
        Box(
            modifier = Modifier.width(44.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            if (actionIcon != null && onActionClick != null) {
                NexoIconButton(
                    icon = actionIcon,
                    onClick = onActionClick,
                    size = 36.dp,
                    iconSize = 18.dp
                )
            }
        }
    }
}
