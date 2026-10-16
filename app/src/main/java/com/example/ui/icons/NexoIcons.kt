package com.example.ui.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object NexoIcons {
    private fun createVector(name: String, pathData: String): ImageVector {
        val nodes = PathParser().parsePathString(pathData).toNodes()
        return ImageVector.Builder(
            name = name,
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).addPath(
            pathData = nodes,
            fill = null,
            stroke = SolidColor(Color.White),
            strokeLineWidth = 1.8f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round
        ).build()
    }

    val home: ImageVector by lazy { createVector("home", "M3 11l 9-8 9 8M5 10v10h14V10M9 20v-6h6v6") }
    val wallet: ImageVector by lazy { createVector("wallet", "M6 6H18a3 3 0 0 1 3 3V17a3 3 0 0 1 -3 3H6a3 3 0 0 1 -3 -3V9a3 3 0 0 1 3 -3ZM17 11h4v5h-4a2.5 2.5 0 0 1 0-5ZM6 6V5a2 2 0 0 1 2-2h9") }
    val scan: ImageVector by lazy { createVector("scan", "M8 3H5a2 2 0 0 0-2 2v3M16 3h3a2 2 0 0 1 2 2v3M8 21H5a2 2 0 0 1-2-2v-3M16 21h3a2 2 0 0 0 2-2v-3M7 12h10") }
    val activity: ImageVector by lazy { createVector("activity", "M4 18V9M10 18V5M16 18v-7M22 18V3M2 21h21") }
    val user: ImageVector by lazy { createVector("user", "M8 8a4 4 0 1 0 8 0a4 4 0 1 0 -8 0M4 21a8 8 0 0 1 16 0") }
    val bell: ImageVector by lazy { createVector("bell", "M18 8a6 6 0 0 0-12 0c0 7-3 7-3 9h18c0-2-3-2-3-9M10 21h4") }
    val eye: ImageVector by lazy { createVector("eye", "M2 12s3.5-6 10-6 10 6 10 6-3.5 6-10 6S2 12 2 12ZM9.5 12a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0") }
    val eyeOff: ImageVector by lazy { createVector("eyeOff", "M3 3l 18 18M10.6 10.6a2 2 0 0 0 2.8 2.8M9.4 5.2A11 11 0 0 1 12 5c6.5 0 10 7 10 7a15 15 0 0 1-2 2.8M6.6 6.6C3.6 8.3 2 12 2 12s3.5 7 10 7a10 10 0 0 0 4-.8") }
    val arrowUp: ImageVector by lazy { createVector("arrowUp", "M12 19V5M6 11l6-6 6 6") }
    val arrowDown: ImageVector by lazy { createVector("arrowDown", "M12 5v14M18 13l-6 6-6-6") }
    val plus: ImageVector by lazy { createVector("plus", "M12 5v14M5 12h14") }
    val chevron: ImageVector by lazy { createVector("chevron", "M9 18l 6-6-6-6") }
    val copy: ImageVector by lazy { createVector("copy", "M10 8H18a2 2 0 0 1 2 2V18a2 2 0 0 1 -2 2H10a2 2 0 0 1 -2 -2V10a2 2 0 0 1 2 -2ZM16 8V6a2 2 0 0 0-2-2H6a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2") }
    val flash: ImageVector by lazy { createVector("flash", "M13 2l-8 12h7l-1 8 8-12h-7l1-8Z") }
    val image: ImageVector by lazy { createVector("image", "M6 4H18a3 3 0 0 1 3 3V17a3 3 0 0 1 -3 3H6a3 3 0 0 1 -3 -3V7a3 3 0 0 1 3 -3ZM7 9a2 2 0 1 0 4 0a2 2 0 1 0 -4 0M3 16l 4-4 4 4 3-3 7 7") }
    val keyboard: ImageVector by lazy { createVector("keyboard", "M5 5H19a3 3 0 0 1 3 3V16a3 3 0 0 1 -3 3H5a3 3 0 0 1 -3 -3V8a3 3 0 0 1 3 -3ZM6 9h.01M10 9h.01M14 9h.01M18 9h.01M6 13h.01M10 13h.01M14 13h4M7 16h10") }
    val shield: ImageVector by lazy { createVector("shield", "M12 22s8-3.5 8-10V5l-8-3-8 3v7c0 6.5 8 10 8 10ZM9 12l 2 2 4-4") }
    val check: ImageVector by lazy { createVector("check", "M5 12l 4 4L19 6") }
    val clock: ImageVector by lazy { createVector("clock", "M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0M12 7v5l3 2") }
    val close: ImageVector by lazy { createVector("close", "M6 6l 12 12M18 6 6 18") }
    val store: ImageVector by lazy { createVector("store", "M4 10v10h16V10M3 4h18l-2 6H5L3 4ZM9 20v-6h6v6") }
    val restaurant: ImageVector by lazy { createVector("restaurant", "M7 3v8M4 3v5a3 3 0 0 0 6 0V3M7 11v10M17 3v18M17 3c-3 2-3 8 0 9") }
    val swap: ImageVector by lazy { createVector("swap", "M7 7l 3-3 3 3M10 4v12M17 17l-3 3-3-3M14 20V8") }
    val send: ImageVector by lazy { createVector("send", "M22 2l-7 20-4-9-9-4 20-7ZM22 2 11 13") }
    val settings: ImageVector by lazy { createVector("settings", "M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0M19.4 15a1.7 1.7 0 0 0 .3 1.9l.1.1-2.8 2.8-.1-.1a1.7 1.7 0 0 0-1.9-.3 1.7 1.7 0 0 0-1 1.6v.2h-4V21a1.7 1.7 0 0 0-1-1.6 1.7 1.7 0 0 0-1.9.3l-.1.1L4.2 17l.1-.1a1.7 1.7 0 0 0 .3-1.9A1.7 1.7 0 0 0 3 14H2.8v-4H3a1.7 1.7 0 0 0 1.6-1 1.7 1.7 0 0 0-.3-1.9L4.2 7 7 4.2l.1.1a1.7 1.7 0 0 0 1.9.3A1.7 1.7 0 0 0 10 3v-.2h4V3a1.7 1.7 0 0 0 1 1.6 1.7 1.7 0 0 0 1.9-.3l.1-.1L19.8 7l-.1.1a1.7 1.7 0 0 0-.3 1.9 1.7 1.7 0 0 0 1.6 1h.2v4H21a1.7 1.7 0 0 0-1.6 1Z") }
    val help: ImageVector by lazy { createVector("help", "M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0M9.8 9a2.3 2.3 0 1 1 3.5 2c-1.3.7-1.3 1.2-1.3 2M12 17h.01") }
    val logout: ImageVector by lazy { createVector("logout", "M10 17l5-5-5-5M15 12H3M15 4h4a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2h-4") }
    val lock: ImageVector by lazy { createVector("lock", "M7 10H17a3 3 0 0 1 3 3V18a3 3 0 0 1 -3 3H7a3 3 0 0 1 -3 -3V13a3 3 0 0 1 3 -3ZM8 10V7a4 4 0 0 1 8 0v3") }
    val file: ImageVector by lazy { createVector("file", "M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8ZM14 2v6h6M8 13h8M8 17h5") }
    val back: ImageVector by lazy { createVector("back", "M15 18l-6-6 6-6") }
    val info: ImageVector by lazy { createVector("info", "M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0M12 11v6M12 7h.01") }
    val download: ImageVector by lazy { createVector("download", "M12 3v12M7 10l5 5 5-5M5 21h14") }
    val refresh: ImageVector by lazy { createVector("refresh", "M20 7h-6V1M4 17h6v6M20 7a9 9 0 0 0-15-2M4 17a9 9 0 0 0 15 2") }

    fun getByName(name: String): ImageVector {
        return when (name.lowercase()) {
            "home" -> home
            "wallet" -> wallet
            "scan" -> scan
            "activity" -> activity
            "user" -> user
            "bell" -> bell
            "eye" -> eye
            "eyeoff", "eye-off", "eye_off" -> eyeOff
            "arrowup", "arrow-up", "arrow_up" -> arrowUp
            "arrowdown", "arrow-down", "arrow_down" -> arrowDown
            "plus" -> plus
            "chevron" -> chevron
            "copy" -> copy
            "flash" -> flash
            "image" -> image
            "keyboard" -> keyboard
            "shield" -> shield
            "check" -> check
            "clock" -> clock
            "close" -> close
            "store" -> store
            "restaurant" -> restaurant
            "swap" -> swap
            "send" -> send
            "settings" -> settings
            "help" -> help
            "logout" -> logout
            "lock" -> lock
            "file" -> file
            "back" -> back
            "info" -> info
            "download" -> download
            "refresh" -> refresh
            else -> home
        }
    }
}

@Composable
fun NexoIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    tamanho: Dp = 24.dp,
    cor: Color = LocalContentColor.current
) {
    Image(
        imageVector = icon,
        contentDescription = icon.name,
        modifier = modifier.size(tamanho),
        colorFilter = ColorFilter.tint(cor)
    )
}

@Composable
fun NexoIcon(
    nome: String,
    modifier: Modifier = Modifier,
    tamanho: Dp = 24.dp,
    cor: Color = LocalContentColor.current
) {
    val vector = remember(nome) { NexoIcons.getByName(nome) }
    NexoIcon(
        icon = vector,
        modifier = modifier,
        tamanho = tamanho,
        cor = cor
    )
}
