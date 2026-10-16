package com.example.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = NexoAccent,
    onPrimary = NexoOnAccent,
    primaryContainer = NexoSurface2,
    onPrimaryContainer = NexoText,
    secondary = NexoSurface2,
    onSecondary = NexoText,
    background = NexoBg,
    onBackground = NexoText,
    surface = NexoSurface,
    onSurface = NexoText,
    surfaceVariant = NexoSurface3,
    onSurfaceVariant = NexoMuted,
    outline = NexoLine,
    error = NexoDanger,
    onError = NexoText
)

@Composable
fun NexoPayTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                window.statusBarColor = NexoBg.toArgb()
                window.navigationBarColor = NexoBg.toArgb()
                val insetsController = WindowCompat.getInsetsController(window, view)
                insetsController.isAppearanceLightStatusBars = false
                insetsController.isAppearanceLightNavigationBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = AppTypography,
        content = content
    )
}
