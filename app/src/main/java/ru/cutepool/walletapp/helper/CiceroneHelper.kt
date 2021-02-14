package ru.cutepool.walletapp.helper

import ru.cutepool.walletapp.app.App
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

object CiceroneHelper {
    @JvmStatic
    fun router(): Router = App.getInstance().router()
    @JvmStatic
    fun navHolder(): NavigatorHolder = App.getInstance().navigatorHolder()
}
