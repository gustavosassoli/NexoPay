package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui.icons.NexoIcon
import com.example.ui.theme.NexoAccent
import com.example.ui.theme.NexoLine
import com.example.ui.theme.NexoSurface
import com.example.ui.theme.NexoText
import com.example.ui.theme.ShapeRadius13

@Composable
fun NexoIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    iconSize: Dp = 20.dp,
    tint: Color = NexoText,
    showBadgeDot: Boolean = false
) {
    val buttonBg = Color(0xCC141C2F) // rgba(20,28,47,0.8)

    Box(
        modifier = modifier
            .size(size)
            .clip(ShapeRadius13)
            .background(buttonBg)
            .border(1.dp, NexoLine, ShapeRadius13)
            .clickable(
                role = Role.Button,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        NexoIcon(
            icon = icon,
            tamanho = iconSize,
            cor = tint
        )

        if (showBadgeDot) {
            // Badge dot: 6dp accent with 2dp surface border at top 8, right 9
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = (-8).dp, y = 7.dp)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(NexoSurface)
                    .padding(1.dp)
                    .clip(CircleShape)
                    .background(NexoAccent)
            )
        }
    }
}
