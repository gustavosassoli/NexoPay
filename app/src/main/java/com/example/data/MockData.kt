package com.example.data

import java.math.BigDecimal

data class Asset(
    val code: String,
    val name: String,
    val amount: BigDecimal,
    val usdCents: Long,
    val brlCentavos: Long,
    val rateBrl: BigDecimal? = null,
    val changeText: String = ""
)

enum class ActivityTone {
    OUT,
    IN,
    SWAP
}

data class TransactionActivity(
    val id: String,
    val iconName: String,
    val title: String,
    val detail: String,
    val dateText: String,
    val brlCentavos: Long? = null,
    val usdCents: Long? = null,
    val isPositive: Boolean = false,
    val cryptoAmount: BigDecimal,
    val cryptoSymbol: String,
    val cryptoPrefix: String = "",
    val tone: ActivityTone
)

object MockData {
    val userName = "Gustavo"
    val fullName = "Gustavo Martins"
    val userEmail = "gustavo@exemplo.com"
    val avatarInitials = "GM"

    val totalBalanceUsdCents = 128450L // US$ 1.284,50
    val estimatedBalanceBrlCentavos = 662260L // R$ 6.622,60

    val assets = listOf(
        Asset(
            code = "USDT",
            name = "Tether",
            amount = BigDecimal("850.00"),
            usdCents = 85000L,
            brlCentavos = 438175L,
            rateBrl = BigDecimal("5.155"),
            changeText = "+0,12% hoje"
        ),
        Asset(
            code = "USDC",
            name = "USD Coin",
            amount = BigDecimal("334.50"),
            usdCents = 33450L,
            brlCentavos = 172486L,
            rateBrl = BigDecimal("5.155")
        ),
        Asset(
            code = "ETH",
            name = "Ethereum",
            amount = BigDecimal("0.039"),
            usdCents = 10000L,
            brlCentavos = 51550L,
            rateBrl = BigDecimal("13218.00")
        )
    )

    val activities = listOf(
        TransactionActivity(
            id = "tx-1",
            iconName = "store",
            title = "Mercado Vila Nova",
            detail = "Pagamento Pix",
            dateText = "Hoje, 10:42",
            brlCentavos = -12840L,
            cryptoAmount = BigDecimal("24.92"),
            cryptoSymbol = "USDT",
            cryptoPrefix = "−",
            tone = ActivityTone.OUT
        ),
        TransactionActivity(
            id = "tx-2",
            iconName = "restaurant",
            title = "Restaurante Moma",
            detail = "Pagamento Pix",
            dateText = "Ontem, 20:16",
            brlCentavos = -8600L,
            cryptoAmount = BigDecimal("16.70"),
            cryptoSymbol = "USDC",
            cryptoPrefix = "−",
            tone = ActivityTone.OUT
        ),
        TransactionActivity(
            id = "tx-3",
            iconName = "arrowDown",
            title = "Recebimento",
            detail = "Carteira externa",
            dateText = "12 Jun, 14:08",
            usdCents = 25000L,
            isPositive = true,
            cryptoAmount = BigDecimal("250.00"),
            cryptoSymbol = "USDT",
            cryptoPrefix = "+",
            tone = ActivityTone.IN
        ),
        TransactionActivity(
            id = "tx-4",
            iconName = "swap",
            title = "Conversão",
            detail = "ETH → USDT",
            dateText = "10 Jun, 09:31",
            usdCents = 10000L,
            isPositive = false,
            cryptoAmount = BigDecimal("0.039"),
            cryptoSymbol = "ETH",
            cryptoPrefix = "",
            tone = ActivityTone.SWAP
        )
    )
}
