package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.components.TopBar
import com.example.ui.theme.InterFontFamily
import com.example.ui.theme.NexoBg
import com.example.ui.theme.NexoMuted

@Composable
fun PlaceholderScreen(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    showCompactBrand: Boolean = false,
    hasBottomNav: Boolean = false
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(NexoBg)
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp,
                bottom = if (hasBottomNav) 112.dp else 36.dp
            )
    ) {
        TopBar(
            title = title,
            onBackClick = onBackClick,
            showCompactBrand = showCompactBrand
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.under_construction),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                color = NexoMuted
            )
        }
    }
}
