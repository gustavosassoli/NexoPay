package com.example.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.icons.NexoIcon
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoAccent
import com.example.ui.theme.NexoDanger
import com.example.ui.theme.NexoLine
import com.example.ui.theme.NexoMuted
import com.example.ui.theme.NexoOnAccent
import com.example.ui.theme.NexoSurface2
import com.example.ui.theme.NexoText
import com.example.ui.theme.ShapeRadius16

enum class NexoButtonVariant {
    PRIMARY,
    SECONDARY,
    GHOST,
    DANGER
}

@Composable
fun NexoButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: NexoButtonVariant = NexoButtonVariant.PRIMARY,
    icon: ImageVector? = null,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) 0.985f else 1f,
        animationSpec = tween(durationMillis = 200),
        label = "btnScale"
    )

    val bgColor = when (variant) {
        NexoButtonVariant.PRIMARY -> NexoAccent
        NexoButtonVariant.SECONDARY -> NexoSurface2
        NexoButtonVariant.GHOST -> Color.Transparent
        NexoButtonVariant.DANGER -> NexoDanger
    }

    val contentColor = when (variant) {
        NexoButtonVariant.PRIMARY -> NexoOnAccent
        NexoButtonVariant.SECONDARY -> NexoText
        NexoButtonVariant.GHOST -> NexoMuted
        NexoButtonVariant.DANGER -> Color.White
    }

    val borderModifier = if (variant == NexoButtonVariant.SECONDARY) {
        Modifier.border(1.dp, NexoLine, ShapeRadius16)
    } else {
        Modifier
    }

    // Shadow for primary button: 0/10/25, accent at 12%
    val shadowModifier = if (variant == NexoButtonVariant.PRIMARY) {
        Modifier.drawBehind {
            drawIntoCanvas { canvas ->
                val paint = Paint().apply {
                    color = NexoAccent.copy(alpha = 0.12f)
                    style = PaintingStyle.Fill
                    asFrameworkPaint().apply {
                        maskFilter = android.graphics.BlurMaskFilter(
                            25f,
                            android.graphics.BlurMaskFilter.Blur.NORMAL
                        )
                    }
                }
                canvas.drawRoundRect(
                    left = 0f,
                    top = 10f,
                    right = size.width,
                    bottom = size.height + 10f,
                    radiusX = 16.dp.toPx(),
                    radiusY = 16.dp.toPx(),
                    paint = paint
                )
            }
        }
    } else {
        Modifier
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .scale(scale)
            .then(shadowModifier)
            .clip(ShapeRadius16)
            .background(bgColor)
            .then(borderModifier)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
                role = Role.Button,
                onClick = onClick
            )
            .defaultMinSize(minHeight = 51.dp)
            .padding(horizontal = 16.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                NexoIcon(
                    icon = icon,
                    tamanho = 18.dp,
                    cor = contentColor,
                    modifier = Modifier.padding(end = 9.dp)
                )
            }
            Text(
                text = text,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W700,
                fontSize = 12.sp,
                color = contentColor
            )
        }
    }
}
