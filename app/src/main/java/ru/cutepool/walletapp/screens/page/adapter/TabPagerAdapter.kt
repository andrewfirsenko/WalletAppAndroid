package ru.cutepool.walletapp.screens.page.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.cutepool.walletapp.app.App
import ru.cutepool.walletapp.models.NamesTabs
import ru.cutepool.walletapp.screens.page.PageFragment

class TabPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabs = NamesTabs.values()

    override fun getItem(position: Int): Fragment {
        return PageFragment.newInstance(tabs[position])
    }

    override fun getCount(): Int {
        return tabs.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return App.getInstance().applicationContext.getString(tabs[position].nameResource)
    }

}