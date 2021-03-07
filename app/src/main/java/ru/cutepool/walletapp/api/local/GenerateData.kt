package ru.cutepool.walletapp.api.local

import android.util.Log
import ru.cutepool.walletapp.models.Card
import ru.cutepool.walletapp.models.CardFull
import ru.cutepool.walletapp.models.Transaction
import java.math.BigDecimal
import java.math.RoundingMode

object GenerateData {

    fun generateTransactions(count: Int): List<Transaction> {
        val data = mutableListOf<Transaction>()
        for (i in 1..count) {
            val amount = (-100000..100000).random().toDouble() / 100
            data.add(
                Transaction(
                id = "id_$i",
                amount = BigDecimal(amount).setScale(2, RoundingMode.DOWN)
            ))
        }
        return data
    }

    fun generateCardsFull(count: Int): List<CardFull> {
        val data = mutableListOf<CardFull>()
        for (i in 1..count) {
            val number = (1..30).random()
            val transactions = generateTransactions(number)
            var summ = BigDecimal(0).setScale(2, RoundingMode.DOWN)
            for (i in transactions) {
                summ = summ.add(i.amount)
            }
            data.add(
                CardFull(
                    id = "id_$i",
                    name = "Name card $i",
                    transactions = transactions as MutableList<Transaction>,
                    amount = summ
                )
            )
        }
        return data
    }

    fun generateCards(count: Int): List<Card> {
        val data = mutableListOf<Card>()
        for (i in 1..count) {
            val amount = BigDecimal((-100000000..100000000).random().toDouble() / 100).setScale(2, RoundingMode.DOWN)
            data.add(
                Card(
                    id = "id_$i",
                    name = "Name card $i",
                    amount = amount
                ))
        }
        return data
    }

}