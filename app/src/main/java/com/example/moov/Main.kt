package com.example.moov

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moov.fragments.CalculateFragment
import com.example.moov.fragments.DashboardFragment
import com.example.moov.fragments.ProfileFragment
import com.example.moov.fragments.ShipmentFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val dashboardFragment = DashboardFragment()
        val calculateFragment = CalculateFragment()
        val shipmentFragment = ShipmentFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(dashboardFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.navigation_home ->makeCurrentFragment(dashboardFragment)
                R.id.navigation_calculate->makeCurrentFragment(calculateFragment)
                R.id.navigation_shipment->makeCurrentFragment(shipmentFragment)
                R.id.navigation_profile->makeCurrentFragment(profileFragment)
            }
            true
        }


    }

    private fun makeCurrentFragment(fragment:Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper,fragment)
        commit()
    }
}