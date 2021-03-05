package ru.cutepool.walletapp.screens.page.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smarteist.autoimageslider.SliderViewAdapter
import ru.cutepool.walletapp.R

class BalanceAdapter : SliderViewAdapter<BalanceAdapter.BalanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?): BalanceViewHolder {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_view_balance, parent, false)
        return BalanceViewHolder(
            itemView
        )
    }

    override fun getCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: BalanceViewHolder, position: Int) {

    }

    class BalanceViewHolder(itemView: View) : ViewHolder(itemView)

}
