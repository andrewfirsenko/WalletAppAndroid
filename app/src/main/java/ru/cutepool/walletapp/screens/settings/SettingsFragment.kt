package ru.cutepool.walletapp.screens.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.cutepool.walletapp.R
import ru.cutepool.walletapp.RouterViewModelFactory
import ru.cutepool.walletapp.activities.main.MainViewModel
import ru.cutepool.walletapp.helper.CiceroneHelper


class SettingsFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
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
        fun newInstance(): SettingsFragment = SettingsFragment()
    }

}
