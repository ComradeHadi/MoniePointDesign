package com.example.moov

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.moov.fragments.AllFragment
import com.example.moov.fragments.CancelledFragment
import com.example.moov.fragments.CompletedFragment
import com.example.moov.fragments.InProgressFragment
import com.example.moov.fragments.PendingOrderFragment
import com.example.moov.fragments.ShipmentFragment

class TabPagerAdapter(fragmentActivity: ShipmentFragment) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllFragment()
            1 -> CompletedFragment()
            2 -> InProgressFragment()
            3 -> PendingOrderFragment()
            4 -> CancelledFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
