package com.example.ui.theme

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Dimens tokens for NEXO PAY.
 * Rule: any text smaller than MIN_TEXT_SP is drawn with MIN_TEXT_SP.
 * If 1:1 prototype fidelity is needed without the floor, set MIN_TEXT_SP = 0f.
 */
const val MIN_TEXT_SP: Float = 11f

fun nexoSp(value: Float): TextUnit {
    return if (value < MIN_TEXT_SP) MIN_TEXT_SP.sp else value.sp
}

fun nexoSp(value: Int): TextUnit = nexoSp(value.toFloat())
