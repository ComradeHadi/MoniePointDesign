package com.example.moov.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.moov.R
import com.example.moov.TabPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ShipmentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shipment, container, false)
    }

    @SuppressLint("MissingInflatedId", "SetTextI18n", "InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)

        viewPager.adapter = TabPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null)

            val tabLabel = tabView.findViewById<TextView>(R.id.tabLabel)
            val tabCustomBadge = tabView.findViewById<TextView>(R.id.tabCustomBadge)

            when (position) {
                0 -> {
                    tabLabel.text = "All"
                    tabCustomBadge.text = "10"
                }
                1 -> {
                    tabLabel.text = "Completed"
                    tabCustomBadge.text = "4"
                }
                2 -> {
                    tabLabel.text = "In-progress"
                    tabCustomBadge.text = "1"
                }
                3 -> {
                    tabLabel.text = "Pending Order"
                    tabCustomBadge.text = "1"
                }
                4 -> {
                    tabLabel.text = "Cancelled"
                    tabCustomBadge.text = "1"
                }

            }

            tab.customView = tabView
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.customView?.isSelected = true
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.customView?.isSelected = false
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}
