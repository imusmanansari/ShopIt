package com.example.shopit.UI.Dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.shopit.R
import com.example.shopit.UI.Dashboard.Fragments.CartFragment
import com.example.shopit.UI.Dashboard.Fragments.HomeFragment
import com.example.shopit.UI.Dashboard.Fragments.NotificationFragment
import com.example.shopit.UI.Dashboard.Fragments.SettingFragment
import com.example.shopit.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {

    private lateinit var binding:ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.navigation_home->replaceFragment(HomeFragment())
                R.id.navigation_notifications->replaceFragment(NotificationFragment())
                R.id.navigation_cart->replaceFragment(CartFragment())
                R.id.navigation_settings->replaceFragment(SettingFragment())

                else->{

                }
            }
            true

        }


    }

    private fun replaceFragment(fragment:Fragment){

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }


}