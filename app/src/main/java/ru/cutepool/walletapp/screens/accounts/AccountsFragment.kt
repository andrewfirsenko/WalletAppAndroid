package ru.cutepool.walletapp.screens.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.accounts_toolbar.*
import kotlinx.android.synthetic.main.fragment_accounts.*
import ru.cutepool.walletapp.R
import ru.cutepool.walletapp.RouterViewModelFactory
import ru.cutepool.walletapp.activities.main.MainViewModel
import ru.cutepool.walletapp.helper.CiceroneHelper
import ru.cutepool.walletapp.models.NamesTabs
import ru.cutepool.walletapp.screens.page.TabPagerAdapter


class AccountsFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_accounts, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
        initTabs()
        initTabsToolbar()
        initViewPager()
    }

    private fun initViewModel() {
        val mainViewModelFactory = RouterViewModelFactory(CiceroneHelper.router())
        mainViewModel = requireActivity().run {
            ViewModelProvider(this, mainViewModelFactory)
                .get(MainViewModel::class.java)
        }
    }

    private fun initTabs() {
        for (i in NamesTabs.values()) {
            frg_accounts__tabLayout.addTab(frg_accounts__tabLayout.newTab())
        }
        frg_accounts__tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })
        frg_accounts__tabLayout.setScrollPosition(0, 0F, true)

    }

    private fun initTabsToolbar() {
        ic_setting_button.setOnClickListener {
//            mainViewModel.toSettingsScreen()
        }
    }

    private fun initViewPager() {
        frg_accounts__view_pager.adapter =
            TabPagerAdapter(
                requireActivity().supportFragmentManager,
                lifecycle
            )
        TabLayoutMediator(frg_accounts__tabLayout, frg_accounts__view_pager) { tab, position ->
            val name = context?.getString(NamesTabs.values()[position].nameResource)
            tab.text = name
        }.attach()
    }

    companion object {
        fun newInstance(): AccountsFragment = AccountsFragment()
    }

}
