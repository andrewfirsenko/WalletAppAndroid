package ru.cutepool.walletapp.screens.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_page.*
import ru.cutepool.walletapp.R
import ru.cutepool.walletapp.screens.accounts.AccountsFragment

class PageFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewPagerBalance()
        initRecyclerView()
    }

    private fun initViewPagerBalance() {
        frg_page__vp_balance.adapter = ViewPagerBalanceAdapter()
    }

    private fun initRecyclerView() {
        frg_page__rv_items.layoutManager = LinearLayoutManager(context)
        frg_page__rv_items.adapter = PageItemsAdapter()
    }

    companion object {
        fun newInstance(): AccountsFragment =
            AccountsFragment()
    }

}