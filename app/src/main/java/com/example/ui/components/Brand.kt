package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoAccent
import com.example.ui.theme.NexoBg
import com.example.ui.theme.NexoText

@Composable
fun BrandIcon(
    modifier: Modifier = Modifier,
    size: Dp = 27.dp
) {
    Canvas(modifier = modifier.size(size)) {
        val scale = this.size.width / 27f
        val cornerRadius = 9f * scale

        // Background rounded square
        drawRoundRect(
            color = NexoAccent,
            size = this.size,
            cornerRadius = CornerRadius(cornerRadius, cornerRadius)
        )

        val barWidth = 17f * scale
        val barHeight = 5f * scale
        val barRadius = 2.5f * scale

        // First bar: left 2, top 8
        rotate(degrees = 42f, pivot = Offset((2f + 17f / 2f) * scale, (8f + 5f / 2f) * scale)) {
            drawRoundRect(
                color = NexoBg,
                topLeft = Offset(2f * scale, 8f * scale),
                size = Size(barWidth, barHeight),
                cornerRadius = CornerRadius(barRadius, barRadius)
            )
        }

        // Second bar: left 8, top 14
        rotate(degrees = 42f, pivot = Offset((8f + 17f / 2f) * scale, (14f + 5f / 2f) * scale)) {
            drawRoundRect(
                color = NexoBg,
                topLeft = Offset(8f * scale, 14f * scale),
                size = Size(barWidth, barHeight),
                cornerRadius = CornerRadius(barRadius, barRadius)
            )
        }
    }
}

@Composable
fun Brand(
    modifier: Modifier = Modifier,
    compact: Boolean = false
) {
    if (compact) {
        BrandIcon(modifier = modifier, size = 32.dp)
    } else {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            BrandIcon(size = 27.dp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "NEXO",
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.W800,
                    fontSize = 15.sp,
                    letterSpacing = 0.12.em,
                    color = NexoText
                )
                Text(
                    text = " PAY",
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.W800,
                    fontSize = 15.sp,
                    letterSpacing = 0.12.em,
                    color = NexoAccent
                )
            }
        }
    }
}
