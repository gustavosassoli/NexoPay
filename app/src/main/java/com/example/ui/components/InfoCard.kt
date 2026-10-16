package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.icons.NexoIcon
import com.example.ui.icons.NexoIcons
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoInfoBg
import com.example.ui.theme.NexoInfoBorder
import com.example.ui.theme.NexoInfoCardText
import com.example.ui.theme.NexoWarning
import com.example.ui.theme.NexoWarningAlpha07
import com.example.ui.theme.NexoWarningAlpha15
import com.example.ui.theme.NexoWarningText
import com.example.ui.theme.ShapeRadius15
import com.example.ui.theme.nexoSp

@Composable
fun WarningCard(
    text: String,
    modifier: Modifier = Modifier,
    icon: ImageVector = NexoIcons.shield
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(ShapeRadius15)
            .background(NexoWarningAlpha07)
            .border(1.dp, NexoWarningAlpha15, ShapeRadius15)
            .padding(13.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            NexoIcon(
                icon = icon,
                tamanho = 19.dp,
                cor = NexoWarning
            )
            Text(
                text = text,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W400,
                fontSize = nexoSp(9),
                lineHeight = 16.sp,
                color = NexoWarningText
            )
        }
    }
}

@Composable
fun InfoCard(
    text: String,
    modifier: Modifier = Modifier,
    icon: ImageVector = NexoIcons.info
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(ShapeRadius15)
            .background(NexoInfoBg)
            .border(1.dp, NexoInfoBorder, ShapeRadius15)
            .padding(13.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            NexoIcon(
                icon = icon,
                tamanho = 18.dp,
                cor = NexoInfoCardText
            )
            Text(
                text = text,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W400,
                fontSize = nexoSp(9),
                lineHeight = 16.sp,
                color = NexoInfoCardText
            )
        }
    }
}
