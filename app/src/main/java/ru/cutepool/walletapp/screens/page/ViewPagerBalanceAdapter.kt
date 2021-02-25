package ru.cutepool.walletapp.screens.page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.cutepool.walletapp.R

class ViewPagerBalanceAdapter : RecyclerView.Adapter<ViewPagerBalanceAdapter.BalanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BalanceViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_balance, parent, false)
        return BalanceViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: BalanceViewHolder, position: Int) {

    }

    class BalanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
