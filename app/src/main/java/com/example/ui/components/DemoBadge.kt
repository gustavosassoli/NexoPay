package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.R
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoDemoBadgeText
import com.example.ui.theme.NexoLine
import com.example.ui.theme.NexoWhiteAlpha025
import com.example.ui.theme.ShapePill
import com.example.ui.theme.nexoSp

@Composable
fun DemoBadge(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(ShapePill)
            .background(NexoWhiteAlpha025)
            .border(1.dp, NexoLine, ShapePill)
            .padding(horizontal = 8.dp, vertical = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.demo_badge),
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W700,
            fontSize = nexoSp(8),
            letterSpacing = 0.09.em,
            color = NexoDemoBadgeText
        )
    }
}
