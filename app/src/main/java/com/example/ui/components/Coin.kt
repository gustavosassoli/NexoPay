package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoCoinEthBg
import com.example.ui.theme.NexoCoinEthText
import com.example.ui.theme.NexoCoinUsdcBg
import com.example.ui.theme.NexoCoinUsdcText
import com.example.ui.theme.NexoCoinUsdtBg
import com.example.ui.theme.NexoCoinUsdtText

@Composable
fun Coin(
    symbol: String,
    modifier: Modifier = Modifier,
    size: Dp = 34.dp,
    isLarge: Boolean = false
) {
    val upperSymbol = symbol.uppercase()
    val initial = when {
        upperSymbol.startsWith("USDT") -> "U"
        upperSymbol.startsWith("USDC") -> "U"
        upperSymbol.startsWith("ETH") -> "E"
        else -> upperSymbol.take(1)
    }

    val (bgColor, textColor) = when (upperSymbol) {
        "USDT" -> NexoCoinUsdtBg to NexoCoinUsdtText
        "USDC" -> NexoCoinUsdcBg to NexoCoinUsdcText
        "ETH" -> NexoCoinEthBg to NexoCoinEthText
        else -> NexoCoinUsdtBg to NexoCoinUsdtText
    }

    val finalSize = if (isLarge) 57.dp else size
    val fontSize = if (isLarge) 19.sp else 12.sp

    Box(
        modifier = modifier
            .size(finalSize)
            .clip(CircleShape)
            .background(bgColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initial,
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W800,
            fontSize = fontSize,
            color = textColor
        )
    }
}
