package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.R

val InterFontFamily = FontFamily(
    Font(R.font.inter, FontWeight.W400),
    Font(R.font.inter, FontWeight.W500),
    Font(R.font.inter, FontWeight.W600),
    Font(R.font.inter, FontWeight.W700),
    Font(R.font.inter, FontWeight.W800)
)

object NexoTypography {
    val BalanceLarge = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 32.sp,
        letterSpacing = (-0.045).em,
        color = NexoText
    )

    val ChargeAmount = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 31.sp,
        letterSpacing = (-0.04).em,
        color = NexoText
    )

    val ScreenTitle = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 22.sp,
        color = NexoText
    )

    val SectionTitle = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        letterSpacing = (-0.02).em,
        color = NexoText
    )

    val TopBarTitle = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 15.sp,
        color = NexoText
    )

    val BrandTitle = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 15.sp,
        letterSpacing = 0.12.em
    )

    val ReceiverName = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 15.sp,
        color = NexoText
    )

    val Greeting = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        color = NexoMuted
    )

    val BalanceReais = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        color = NexoBalanceReais
    )

    val BalanceLabel = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 13.sp,
        color = NexoLabelAvailableBalance
    )

    val Button = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 12.sp
    )

    val LineTitle = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = nexoSp(11),
        color = NexoText
    )

    val LineSecondary = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = nexoSp(9),
        color = NexoMuted
    )

    val DemoBadge = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = nexoSp(8),
        letterSpacing = 0.09.em,
        color = NexoDemoBadgeText
    )
}

val AppTypography = Typography(
    headlineLarge = NexoTypography.BalanceLarge,
    headlineMedium = NexoTypography.ScreenTitle,
    headlineSmall = NexoTypography.SectionTitle,
    titleMedium = NexoTypography.TopBarTitle,
    bodyLarge = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        color = NexoText
    ),
    bodyMedium = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = nexoSp(11),
        color = NexoText
    ),
    bodySmall = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = nexoSp(9),
        color = NexoMuted
    ),
    labelLarge = NexoTypography.Button
)
