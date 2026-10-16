package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.data.ActivityTone
import com.example.data.TransactionActivity
import com.example.ui.icons.NexoIcon
import com.example.ui.icons.NexoIcons
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoAccent
import com.example.ui.theme.NexoAccentAlpha10
import com.example.ui.theme.NexoActivityOutIcon
import com.example.ui.theme.NexoActivitySwapBg
import com.example.ui.theme.NexoActivitySwapIcon
import com.example.ui.theme.NexoMuted
import com.example.ui.theme.NexoSurface3
import com.example.ui.theme.NexoText
import com.example.ui.theme.ShapeRadius13
import com.example.ui.theme.nexoSp
import com.example.util.Format

@Composable
fun ActivityItem(
    activity: TransactionActivity,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val (iconBg, iconTint) = when (activity.tone) {
        ActivityTone.OUT -> NexoSurface3 to NexoActivityOutIcon
        ActivityTone.IN -> NexoAccentAlpha10 to NexoAccent
        ActivityTone.SWAP -> NexoActivitySwapBg to NexoActivitySwapIcon
    }

    val primaryAmountText = when {
        activity.brlCentavos != null -> Format.formatBrl(activity.brlCentavos)
        activity.usdCents != null -> Format.formatUsd(activity.usdCents, prefixSign = activity.isPositive)
        else -> ""
    }

    val cryptoText = Format.formatCrypto(
        amount = activity.cryptoAmount,
        symbol = activity.cryptoSymbol,
        prefixSign = activity.cryptoPrefix
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                role = Role.Button,
                onClick = onClick
            )
            .padding(14.dp),
        horizontalArrangement = Arrangement.spacedBy(11.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left Column (39x39 icon box, radius 13)
        Box(
            modifier = Modifier
                .size(39.dp)
                .clip(ShapeRadius13)
                .background(iconBg),
            contentAlignment = Alignment.Center
        ) {
            NexoIcon(
                icon = NexoIcons.getByName(activity.iconName),
                tamanho = 20.dp,
                cor = iconTint
            )
        }

        // Middle Column (1fr)
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                text = activity.title,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W600,
                fontSize = nexoSp(11),
                color = NexoText,
                maxLines = 1
            )
            Text(
                text = "${activity.detail} · ${activity.dateText}",
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W400,
                fontSize = nexoSp(8),
                color = NexoMuted,
                maxLines = 1
            )
        }

        // Right Column (auto)
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                text = primaryAmountText,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W600,
                fontSize = nexoSp(11),
                color = NexoText,
                textAlign = TextAlign.End
            )
            Text(
                text = cryptoText,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W400,
                fontSize = nexoSp(8),
                color = NexoMuted,
                textAlign = TextAlign.End
            )
        }
    }
}
