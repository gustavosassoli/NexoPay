package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.ui.icons.NexoIcon
import com.example.ui.icons.NexoIcons
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoAccent
import com.example.ui.theme.NexoLine
import com.example.ui.theme.NexoNavInactive
import com.example.ui.theme.NexoOnAccent
import com.example.ui.theme.ShapeRadius17
import com.example.ui.theme.nexoSp

enum class BottomNavItem(
    val route: String,
    val titleRes: Int,
    val icon: ImageVector
) {
    HOME("home", R.string.nav_home, NexoIcons.home),
    WALLET("wallet", R.string.nav_wallet, NexoIcons.wallet),
    PAY("scan", R.string.nav_pay, NexoIcons.scan),
    ACTIVITY("activity", R.string.nav_activity, NexoIcons.activity),
    PROFILE("profile", R.string.nav_profile, NexoIcons.user)
}

@Composable
fun BottomNav(
    currentRoute: String,
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val navBg = Color(0xF20B1020) // rgba(11,16,32,0.95)

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // Main bar container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(82.dp)
                .align(Alignment.BottomCenter)
                .background(navBg)
                .drawBehind {
                    // Top line border
                    drawLine(
                        color = NexoLine,
                        start = androidx.compose.ui.geometry.Offset(0f, 0f),
                        end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                        strokeWidth = 1.dp.toPx()
                    )
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 13.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomNavItem.values().forEach { item ->
                    val isSelected = currentRoute == item.route
                    val isPay = item == BottomNavItem.PAY

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                role = Role.Tab,
                                onClick = { onNavigate(item.route) }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (!isPay) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Box(
                                    modifier = Modifier.size(31.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    NexoIcon(
                                        icon = item.icon,
                                        tamanho = 21.dp,
                                        cor = if (isSelected) NexoAccent else NexoNavInactive
                                    )
                                }
                                Text(
                                    text = stringResource(item.titleRes),
                                    fontFamily = InterFontFamily,
                                    fontWeight = if (isSelected) FontWeight.W600 else FontWeight.W400,
                                    fontSize = nexoSp(9),
                                    color = if (isSelected) NexoAccent else NexoNavInactive
                                )
                            }
                        } else {
                            // Placeholder to keep column spacing balanced
                            Box(modifier = Modifier.size(31.dp))
                        }
                    }
                }
            }
        }

        // Elevated Pagar Tab (centered)
        val isPaySelected = currentRoute == BottomNavItem.PAY.route
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-8).dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    role = Role.Tab,
                    onClick = { onNavigate(BottomNavItem.PAY.route) }
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Elevated icon box: 50x50, radius 17, accent bg, onAccent icon, shadow 0/8/25 accent at 25%
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .drawBehind {
                        drawIntoCanvas { canvas ->
                            val paint = Paint().apply {
                                color = NexoAccent.copy(alpha = 0.25f)
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
                                top = 8f,
                                right = size.width,
                                bottom = size.height + 8f,
                                radiusX = 17.dp.toPx(),
                                radiusY = 17.dp.toPx(),
                                paint = paint
                            )
                        }
                    }
                    .clip(ShapeRadius17)
                    .background(NexoAccent),
                contentAlignment = Alignment.Center
            ) {
                NexoIcon(
                    icon = NexoIcons.scan,
                    tamanho = 24.dp,
                    cor = NexoOnAccent
                )
            }

            Text(
                text = stringResource(R.string.nav_pay),
                fontFamily = InterFontFamily,
                fontWeight = if (isPaySelected) FontWeight.W600 else FontWeight.W500,
                fontSize = nexoSp(9),
                color = if (isPaySelected) NexoAccent else NexoNavInactive,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
