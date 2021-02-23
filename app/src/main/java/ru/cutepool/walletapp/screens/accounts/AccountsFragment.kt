package ru.cutepool.walletapp.screens.accounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_accounts.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.cutepool.walletapp.R
import ru.cutepool.walletapp.RouterViewModelFactory
import ru.cutepool.walletapp.activities.main.MainViewModel
import ru.cutepool.walletapp.helper.CiceroneHelper


class AccountsFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_accounts, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
        setupTabs()
        setupTabsToolbar()
    }

    private fun initViewModel() {
        val mainViewModelFactory = RouterViewModelFactory(CiceroneHelper.router())
        mainViewModel = requireActivity().run {
            ViewModelProvider(this, mainViewModelFactory)
                    .get(MainViewModel::class.java)
        }
    }

    private fun setupTabs() {
        frg_accounts__tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab?.position
               text.text = "select item $position"
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })
        frg_accounts__tabLayout.setScrollPosition(0, 0F, true)

    }

    private fun setupTabsToolbar() {
        ic_setting_button.setOnClickListener {
//            mainViewModel.toSettingsScreen()
        }
    }

    companion object {
        fun newInstance(): AccountsFragment = AccountsFragment()
    }

}
