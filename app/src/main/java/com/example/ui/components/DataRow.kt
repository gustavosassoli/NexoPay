package com.example.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoAccent
import com.example.ui.theme.NexoMuted
import com.example.ui.theme.NexoText
import com.example.ui.theme.nexoSp

@Composable
fun DataRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    isStrong: Boolean = false
) {
    if (isStrong) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 52.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W600,
                fontSize = 13.sp,
                color = NexoText,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = value,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W700,
                fontSize = 15.sp,
                color = NexoAccent,
                textAlign = TextAlign.End
            )
        }
    } else {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 36.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W400,
                fontSize = nexoSp(10),
                color = NexoMuted,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = value,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W600,
                fontSize = nexoSp(10),
                color = NexoText,
                textAlign = TextAlign.End
            )
        }
    }
}
