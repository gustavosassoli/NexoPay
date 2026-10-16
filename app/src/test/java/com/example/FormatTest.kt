package com.example

import com.example.util.Format
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal

class FormatTest {

    @Test
    fun testFormatBrl() {
        assertEquals("R$ 128,40", Format.formatBrl(12840L))
        assertEquals("- R$ 128,40", Format.formatBrl(-12840L))
        assertEquals("R$ 6.622,60", Format.formatBrl(662260L))
        assertEquals("- R$ 86,00", Format.formatBrl(-8600L))
        assertEquals("R$ 0,00", Format.formatBrl(0L))
    }

    @Test
    fun testFormatUsd() {
        assertEquals("US$ 1.284,50", Format.formatUsd(128450L))
        assertEquals("US$ 850,00", Format.formatUsd(85000L))
        assertEquals("+ US$ 250,00", Format.formatUsd(25000L, prefixSign = true))
    }

    @Test
    fun testFormatCrypto() {
        assertEquals("25,393 USDT", Format.formatCrypto(BigDecimal("25.393"), "USDT"))
        assertEquals("850,00 USDT", Format.formatCrypto(BigDecimal("850.00"), "USDT"))
        assertEquals("0,039 ETH", Format.formatCrypto(BigDecimal("0.039"), "ETH", minDecimals = 3))
        assertEquals("− 24,92 USDT", Format.formatCrypto(BigDecimal("24.92"), "USDT", prefixSign = "−"))
        assertEquals("+ 250,00 USDT", Format.formatCrypto(BigDecimal("250.00"), "USDT", prefixSign = "+"))
    }
}
