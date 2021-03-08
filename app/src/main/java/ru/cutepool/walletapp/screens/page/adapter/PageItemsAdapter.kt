package ru.cutepool.walletapp.screens.page.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_card.*
import ru.cutepool.walletapp.R
import ru.cutepool.walletapp.models.Card
import java.math.BigDecimal

class PageItemsAdapter : RecyclerView.Adapter<PageItemsAdapter.ItemViewHolder>() {

    private var cards: MutableList<Card> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ItemViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(cards[position])

    }

    fun updateData(data: List<Card>) {
        cards = data as MutableList<Card>
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        private val red = itemView.resources.getColor(R.color.color_red, itemView.context.theme)
        private val green = itemView.resources.getColor(R.color.color_green, itemView.context.theme)

        fun bind(card: Card) {
            item_card__card_name.text = card.name
            if (card.amount > BigDecimal.ZERO) {
                val sumTask = parseAmount(card.amount.abs().toString())
                item_card__amount.setTextColor(green)
                item_card__rouble.setTextColor(green)
                item_card__rouble.text = "₽"
                item_card__amount.text = sumTask.toString()
            } else {
                val sumTask = parseAmount(card.amount.abs().toString())
                item_card__rouble.setTextColor(red)
                item_card__amount.setTextColor(red)
                item_card__rouble.text = "-₽"
                item_card__amount.text = sumTask.toString()
            }
        }

        private fun parseAmount(amount: String): String {
            val pointPosition: Int = amount.indexOf(".")
            var sumTask =
                amount.substring(0, pointPosition - 3).toString() + " " + amount.substring(
                    pointPosition - 3
                )
            for (i in 0 until pointPosition / 3) {
                val lastSpacePosition = sumTask.indexOf(" ")
                sumTask = if (lastSpacePosition - 3 > 0) {
                    sumTask.substring(0, lastSpacePosition - 3) + " " + sumTask.substring(
                        lastSpacePosition - 3
                    )
                } else {
                    break
                }
            }
            return sumTask
        }
    }
}
