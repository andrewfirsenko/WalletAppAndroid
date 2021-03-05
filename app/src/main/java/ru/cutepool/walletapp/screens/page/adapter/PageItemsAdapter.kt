package ru.cutepool.walletapp.screens.page.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.cutepool.walletapp.R

class PageItemsAdapter : RecyclerView.Adapter<PageItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ItemViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}