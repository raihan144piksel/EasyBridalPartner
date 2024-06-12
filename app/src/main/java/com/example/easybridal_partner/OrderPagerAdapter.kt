package com.example.easybridal_partner

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OrderPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OrderListFragment.newInstance("All Orders")
            1 -> OrderListFragment.newInstance("Booked")
            2 -> OrderListFragment.newInstance("Cancelled")
            3 -> OrderListFragment.newInstance("Completed")
            else -> OrderListFragment.newInstance("All Orders")
        }
    }
}
