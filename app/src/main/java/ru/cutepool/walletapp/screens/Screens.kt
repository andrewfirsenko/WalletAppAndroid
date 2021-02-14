package ru.cutepool.walletapp.screens

import androidx.fragment.app.Fragment
import ru.cutepool.walletapp.screens.accounts.AccountsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class AccountsScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return AccountsFragment.newInstance()
        }
    }

}
