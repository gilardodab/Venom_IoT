package com.gilardo.venomshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gilardo.venomshop.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var currentFragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.nav_container,HomeFragment()).commit()
        // now create a menu
        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(bottomListener)
    }

    val bottomListener = BottomNavigationView.OnNavigationItemSelectedListener {
        // switch between ids of menu
        when(it.itemId){
            R.id.home -> {
                currentFragment = HomeFragment()
            }
            R.id.dashboard -> {
                currentFragment = DashboardFragment()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.nav_container,currentFragment).commit()
        true
        }
}

