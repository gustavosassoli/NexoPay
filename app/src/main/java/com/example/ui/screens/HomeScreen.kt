package com.example.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.MockData
import com.example.ui.components.ActivityItem
import com.example.ui.components.Brand
import com.example.ui.components.Coin
import com.example.ui.components.DemoBadge
import com.example.ui.components.NexoIconButton
import com.example.ui.components.SectionTitle
import com.example.ui.icons.NexoIcon
import com.example.ui.icons.NexoIcons
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoAccent
import com.example.ui.theme.NexoAccentAlpha08
import com.example.ui.theme.NexoAccentAlpha15
import com.example.ui.theme.NexoAccentAlpha25
import com.example.ui.theme.NexoBalanceReais
import com.example.ui.theme.NexoBg
import com.example.ui.theme.NexoLabelAvailableBalance
import com.example.ui.theme.NexoLine
import com.example.ui.theme.NexoMuted
import com.example.ui.theme.NexoSmallAssetDollar
import com.example.ui.theme.NexoSurface
import com.example.ui.theme.NexoText
import com.example.ui.theme.ShapeRadius12
import com.example.ui.theme.ShapeRadius14
import com.example.ui.theme.ShapeRadius17
import com.example.ui.theme.ShapeRadius18
import com.example.ui.theme.ShapeRadius19
import com.example.ui.theme.ShapeRadius24
import com.example.ui.theme.nexoSp
import com.example.util.Format

@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isBalanceHidden by remember { mutableStateOf(false) }

    // Screen background with subtle top gradient
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(NexoBg)
            .drawBehind {
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0x331B2742), // rgba(27,39,66,0.2)
                            Color.Transparent
                        ),
                        startY = 0f,
                        endY = 180.dp.toPx()
                    ),
                    size = size
                )
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 112.dp)
        ) {
            // 1. Header (margin 4/0/22)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 22.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Brand()
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = stringResource(R.string.greeting_user),
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp,
                        color = NexoMuted
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Bell icon button with notification dot
                    NexoIconButton(
                        icon = NexoIcons.bell,
                        onClick = { /* Demo notification action */ },
                        size = 40.dp,
                        showBadgeDot = true
                    )

                    // Avatar (42x42, radius 14, border accent 25%, gradient 135° #253753 to #142131, GM accent 700)
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(ShapeRadius14)
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(Color(0xFF253753), Color(0xFF142131)),
                                    start = Offset(0f, 0f),
                                    end = Offset(42f, 42f)
                                )
                            )
                            .border(1.dp, NexoAccentAlpha25, ShapeRadius14)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                role = Role.Button,
                                onClick = { onNavigate("profile") }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = MockData.avatarInitials,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.W700,
                            fontSize = 15.sp,
                            color = NexoAccent
                        )
                    }
                }
            }

            // 2. Balance Card (min height 207, padding 22, radius 24, gradient 145° #192640 to #11192B)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 207.dp)
                    // Shadow 0/22/45 black at 19%
                    .drawBehind {
                        drawIntoCanvas { canvas ->
                            val shadowPaint = Paint().apply {
                                color = Color(0x30000000)
                                style = PaintingStyle.Fill
                                asFrameworkPaint().apply {
                                    maskFilter = android.graphics.BlurMaskFilter(
                                        45f,
                                        android.graphics.BlurMaskFilter.Blur.NORMAL
                                    )
                                }
                            }
                            canvas.drawRoundRect(
                                left = 0f,
                                top = 22f,
                                right = size.width,
                                bottom = size.height + 22f,
                                radiusX = 24.dp.toPx(),
                                radiusY = 24.dp.toPx(),
                                paint = shadowPaint
                            )
                        }
                    }
                    .clip(ShapeRadius24)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(Color(0xFF192640), Color(0xFF11192B)),
                            start = Offset(0f, 0f),
                            end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                        )
                    )
                    .border(1.dp, Color(0x297C99C3), ShapeRadius24) // rgba(124,153,195,0.16)
                    // Radial accent glow at top right (180dp circle, accent at 8%)
                    .drawBehind {
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = listOf(NexoAccent.copy(alpha = 0.08f), Color.Transparent),
                                center = Offset(size.width + 40f, -40f),
                                radius = 180.dp.toPx()
                            ),
                            radius = 180.dp.toPx(),
                            center = Offset(size.width + 40f, -40f)
                        )
                    }
                    .padding(22.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Top row: "Saldo disponível" + Eye toggle button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.available_balance),
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.W400,
                            fontSize = 13.sp,
                            color = NexoLabelAvailableBalance
                        )

                        Box(
                            modifier = Modifier
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                    role = Role.Button,
                                    onClick = { isBalanceHidden = !isBalanceHidden }
                                )
                                .padding(4.dp)
                        ) {
                            NexoIcon(
                                icon = if (isBalanceHidden) NexoIcons.eyeOff else NexoIcons.eye,
                                tamanho = 18.dp,
                                cor = NexoLabelAvailableBalance
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(17.dp))

                    // USD Balance Value
                    Crossfade(
                        targetState = isBalanceHidden,
                        label = "balanceCrossfade"
                    ) { hidden ->
                        Column {
                            Text(
                                text = if (hidden) stringResource(R.string.hidden_balance_usd) else Format.formatUsd(MockData.totalBalanceUsdCents),
                                fontFamily = InterFontFamily,
                                fontWeight = FontWeight.W700,
                                fontSize = 32.sp,
                                letterSpacing = (-0.045).em,
                                color = NexoText
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            // BRL Estimated Value
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = if (hidden) stringResource(R.string.hidden_balance_brl) else "≈ ${Format.formatBrl(MockData.estimatedBalanceBrlCentavos)}",
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.W400,
                                    fontSize = 14.sp,
                                    color = NexoBalanceReais
                                )
                                Text(
                                    text = stringResource(R.string.estimated_quote),
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.W400,
                                    fontSize = nexoSp(10),
                                    color = NexoMuted
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    // Footer with top border line and padding top 15
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .drawBehind {
                                drawLine(
                                    color = NexoLine,
                                    start = Offset(0f, 0f),
                                    end = Offset(size.width, 0f),
                                    strokeWidth = 1.dp.toPx()
                                )
                            }
                            .padding(top = 15.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Left: Protected wallet with glowing accent dot
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .drawBehind {
                                            drawCircle(
                                                color = NexoAccent.copy(alpha = 0.4f),
                                                radius = 6.dp.toPx()
                                            )
                                        }
                                        .clip(CircleShape)
                                        .background(NexoAccent)
                                )
                                Text(
                                    text = stringResource(R.string.protected_wallet),
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.W400,
                                    fontSize = nexoSp(10),
                                    color = NexoMuted
                                )
                            }

                            // Right: DemoBadge
                            DemoBadge()
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 3. Quick Actions (grid 1.25 / 1 / 1, space 10dp, margin bottom 29dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 29.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Action 1: Pagar com Pix (primary, weight 1.25, accent bg, onAccent text/icon)
                Box(
                    modifier = Modifier
                        .weight(1.25f)
                        .defaultMinSize(minHeight = 102.dp)
                        .drawBehind {
                            drawIntoCanvas { canvas ->
                                val paint = Paint().apply {
                                    color = NexoAccentAlpha15
                                    style = PaintingStyle.Fill
                                    asFrameworkPaint().apply {
                                        maskFilter = android.graphics.BlurMaskFilter(
                                            28f,
                                            android.graphics.BlurMaskFilter.Blur.NORMAL
                                        )
                                    }
                                }
                                canvas.drawRoundRect(
                                    left = 0f,
                                    top = 12f,
                                    right = size.width,
                                    bottom = size.height + 12f,
                                    radiusX = 18.dp.toPx(),
                                    radiusY = 18.dp.toPx(),
                                    paint = paint
                                )
                            }
                        }
                        .clip(ShapeRadius18)
                        .background(NexoAccent)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            role = Role.Button,
                            onClick = { onNavigate("scan") }
                        )
                        .padding(horizontal = 8.dp, vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(9.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(37.dp)
                                .clip(ShapeRadius12)
                                .background(Color(0x1A072723)), // rgba(7,39,35,0.1)
                            contentAlignment = Alignment.Center
                        ) {
                            NexoIcon(
                                icon = NexoIcons.scan,
                                tamanho = 24.dp,
                                cor = Color(0xFF05211D)
                            )
                        }
                        Text(
                            text = stringResource(R.string.action_pay_pix),
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.W700,
                            fontSize = 11.sp,
                            color = Color(0xFF05211D),
                            maxLines = 1
                        )
                    }
                }

                // Action 2: Receber cripto
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = 102.dp)
                        .clip(ShapeRadius18)
                        .background(NexoSurface)
                        .border(1.dp, NexoLine, ShapeRadius18)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            role = Role.Button,
                            onClick = { onNavigate("receive") }
                        )
                        .padding(horizontal = 8.dp, vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(9.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(37.dp)
                                .clip(ShapeRadius12)
                                .background(NexoAccentAlpha08),
                            contentAlignment = Alignment.Center
                        ) {
                            NexoIcon(
                                icon = NexoIcons.arrowDown,
                                tamanho = 22.dp,
                                cor = NexoAccent
                            )
                        }
                        Text(
                            text = stringResource(R.string.action_receive_crypto),
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.W600,
                            fontSize = nexoSp(10),
                            color = NexoText,
                            maxLines = 1
                        )
                    }
                }

                // Action 3: Adicionar fundos
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .defaultMinSize(minHeight = 102.dp)
                        .clip(ShapeRadius18)
                        .background(NexoSurface)
                        .border(1.dp, NexoLine, ShapeRadius18)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            role = Role.Button,
                            onClick = { onNavigate("funds") }
                        )
                        .padding(horizontal = 8.dp, vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(9.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(37.dp)
                                .clip(ShapeRadius12)
                                .background(NexoAccentAlpha08),
                            contentAlignment = Alignment.Center
                        ) {
                            NexoIcon(
                                icon = NexoIcons.plus,
                                tamanho = 22.dp,
                                cor = NexoAccent
                            )
                        }
                        Text(
                            text = stringResource(R.string.action_add_funds),
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.W600,
                            fontSize = nexoSp(10),
                            color = NexoText,
                            maxLines = 1
                        )
                    }
                }
            }

            // 4. "Seus ativos" Section
            SectionTitle(
                title = stringResource(R.string.section_your_assets),
                actionText = stringResource(R.string.action_view_wallet),
                onActionClick = { onNavigate("wallet") }
            )

            Spacer(modifier = Modifier.height(13.dp))

            // 3 equal asset cards (padding 12/11, radius 17, space 9dp, margin bottom 29dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 29.dp),
                horizontalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                MockData.assets.forEach { asset ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(ShapeRadius17)
                            .background(NexoSurface)
                            .border(1.dp, NexoLine, ShapeRadius17)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                role = Role.Button,
                                onClick = { onNavigate("asset") }
                            )
                            .padding(horizontal = 11.dp, vertical = 12.dp)
                    ) {
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Coin(symbol = asset.code, size = 34.dp)
                                Column {
                                    Text(
                                        text = asset.code,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.W700,
                                        fontSize = nexoSp(11),
                                        color = NexoText
                                    )
                                    Text(
                                        text = asset.name,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.W400,
                                        fontSize = nexoSp(8),
                                        color = NexoMuted
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = Format.formatUsd(asset.usdCents),
                                fontFamily = InterFontFamily,
                                fontWeight = FontWeight.W700,
                                fontSize = nexoSp(9),
                                color = NexoSmallAssetDollar
                            )
                        }
                    }
                }
            }

            // 5. "Atividade recente" Section
            SectionTitle(
                title = stringResource(R.string.section_recent_activity),
                actionText = stringResource(R.string.action_view_all),
                onActionClick = { onNavigate("activity") }
            )

            Spacer(modifier = Modifier.height(13.dp))

            // Activity List Card (radius 19, surface bg, line border, internal line dividers)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(ShapeRadius19)
                    .background(NexoSurface)
                    .border(1.dp, NexoLine, ShapeRadius19)
            ) {
                Column {
                    val recentList = MockData.activities.take(3)
                    recentList.forEachIndexed { index, activity ->
                        ActivityItem(
                            activity = activity,
                            onClick = { onNavigate("activity-detail") }
                        )

                        if (index < recentList.size - 1) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(NexoLine)
                            )
                        }
                    }
                }
            }
        }
    }
}
