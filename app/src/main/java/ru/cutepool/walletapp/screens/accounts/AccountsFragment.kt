package ru.cutepool.walletapp.screens.accounts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.cutepool.walletapp.R
import ru.cutepool.walletapp.RouterViewModelFactory
import ru.cutepool.walletapp.activities.main.MainViewModel
import ru.cutepool.walletapp.helper.CiceroneHelper
import ru.terrakok.cicerone.android.support.SupportAppNavigator


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
    }

    private fun initViewModel() {
        val mainViewModelFactory = RouterViewModelFactory(CiceroneHelper.router())
        mainViewModel = requireActivity().run {
            ViewModelProvider(this, mainViewModelFactory)
                    .get(MainViewModel::class.java)
        }
    }

    companion object {
        fun newInstance(): AccountsFragment = AccountsFragment()
    }

}
