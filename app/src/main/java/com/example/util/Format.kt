package com.example.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

object Format {
    val ptBrLocale = Locale("pt", "BR")

    private val symbols = DecimalFormatSymbols(ptBrLocale).apply {
        groupingSeparator = '.'
        decimalSeparator = ','
    }

    /**
     * Formata um valor em centavos de Real brasileiro.
     * Exemplo: 12840L -> "R$ 128,40"
     *          -12840L -> "- R$ 128,40"
     */
    fun formatBrl(centavos: Long, prefixSign: Boolean = false): String {
        val isNegative = centavos < 0
        val absCentavos = if (isNegative) -centavos else centavos
        val reais = absCentavos / 100
        val cents = absCentavos % 100

        val thousandsFormat = DecimalFormat("#,##0", symbols)
        val formattedReais = thousandsFormat.format(reais)
        val formattedCents = String.format(ptBrLocale, "%02d", cents)
        val formattedValue = "R$ $formattedReais,$formattedCents"

        return when {
            isNegative -> "- $formattedValue"
            prefixSign -> "+ $formattedValue"
            else -> formattedValue
        }
    }

    /**
     * Formata um valor em centavos de Dólar americano no padrão visual brasileiro.
     * Exemplo: 128450L -> "US$ 1.284,50"
     *          25000L com prefixSign -> "+ US$ 250,00"
     */
    fun formatUsd(cents: Long, prefixSign: Boolean = false): String {
        val isNegative = cents < 0
        val absCents = if (isNegative) -cents else cents
        val dollars = absCents / 100
        val remainder = absCents % 100

        val thousandsFormat = DecimalFormat("#,##0", symbols)
        val formattedDollars = thousandsFormat.format(dollars)
        val formattedCents = String.format(ptBrLocale, "%02d", remainder)
        val formattedValue = "US$ $formattedDollars,$formattedCents"

        return when {
            isNegative -> "- $formattedValue"
            prefixSign -> "+ $formattedValue"
            else -> formattedValue
        }
    }

    /**
     * Formata uma quantidade de token cripto com precisão exata (BigDecimal).
     * Exemplo: BigDecimal("25.393"), "USDT" -> "25,393 USDT"
     *          BigDecimal("850.00"), "USDT" -> "850,00 USDT"
     *          BigDecimal("0.039"), "ETH" -> "0,039 ETH"
     */
    fun formatCrypto(
        amount: BigDecimal,
        symbol: String,
        prefixSign: String = "",
        minDecimals: Int = 2,
        maxDecimals: Int = 5
    ): String {
        val pattern = buildString {
            append("#,##0.")
            repeat(minDecimals) { append("0") }
            repeat(maxDecimals - minDecimals) { append("#") }
        }
        val df = DecimalFormat(pattern, symbols)
        val formatted = df.format(amount)
        val prefix = if (prefixSign.isNotEmpty()) "$prefixSign " else ""
        return "$prefix$formatted $symbol"
    }
}
