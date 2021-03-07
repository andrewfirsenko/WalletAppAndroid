package ru.cutepool.walletapp.models

import java.math.BigDecimal
import java.util.*

data class Transaction(
    var id: String,
    var amount: BigDecimal = BigDecimal(0),
    var date: Date = Date(),
    var category: String = "Другое",
    var note: String = "",
    var isTransaction: Boolean = false,
    var isShow: Boolean = true
)
