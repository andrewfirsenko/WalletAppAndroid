package ru.cutepool.walletapp.models

import java.math.BigDecimal

data class Card(
    var id: String,
    var amount: BigDecimal = BigDecimal(0),
    var name: String
)

data class CardFull(
    var id: String,
    var amount: BigDecimal = BigDecimal(0),
    var name: String,
    val transactions: MutableList<Transaction> = mutableListOf()
)
