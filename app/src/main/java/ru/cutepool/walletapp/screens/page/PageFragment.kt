package ru.cutepool.walletapp.screens.page

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import kotlinx.android.synthetic.main.fragment_page.*
import ru.cutepool.walletapp.R
import ru.cutepool.walletapp.api.local.GenerateData
import ru.cutepool.walletapp.models.NamesTabs
import ru.cutepool.walletapp.screens.page.adapter.BalanceAdapter
import ru.cutepool.walletapp.screens.page.adapter.PageItemsAdapter

class PageFragment(private val tab: NamesTabs) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        retainInstance = true
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewPagerBalance()
        initRecyclerView()

        val cards = GenerateData.generateCards(10)
        for (card in cards) {
            Log.d("log", "${card.name} ${card.amount}")
        }
    }

    private fun initViewPagerBalance() {
        frg_page__balance.setIndicatorAnimation(IndicatorAnimationType.SWAP)
        frg_page__balance.setSliderAdapter(BalanceAdapter())
    }

    private fun initRecyclerView() {
        frg_page__rv_items.layoutManager = LinearLayoutManager(context)
        frg_page__rv_items.adapter =
            PageItemsAdapter()
    }

    override fun onPause() {
        super.onPause()
        frg_page__app_bar_layout.setExpanded(true)
        frg_page__rv_items.scrollToPosition(0)
    }

    companion object {
        fun newInstance(tab: NamesTabs): PageFragment =
            PageFragment(tab)
    }

}