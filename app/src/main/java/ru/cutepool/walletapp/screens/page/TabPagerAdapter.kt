package ru.cutepool.walletapp.screens.page

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.cutepool.walletapp.screens.page.PageFragment

class TabPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    var fragment:ArrayList<Fragment> = arrayListOf(
        PageFragment(),
        PageFragment(),
        PageFragment(),
        PageFragment()
    )

    override fun getItemCount(): Int {
        return fragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragment[position]
    }
}