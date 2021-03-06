package ru.cutepool.walletapp.activities.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import ru.cutepool.walletapp.BackViewModel
import ru.cutepool.walletapp.helper.CiceroneHelper
import ru.cutepool.walletapp.screens.Screens
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainViewModel(private val router: Router) : BackViewModel(router), LifecycleObserver {

    private lateinit var navigator: SupportAppNavigator
    private val navHolder = CiceroneHelper.navHolder()

    fun createAccountsScreen() {
        router.newRootChain(Screens.AccountsScreen())
    }

    fun setNavigator(navigator: SupportAppNavigator) {
        this.navigator = navigator
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun setNavigator() {
        navHolder.setNavigator(navigator)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun removeNavigator() {
        navHolder.removeNavigator()
    }
}