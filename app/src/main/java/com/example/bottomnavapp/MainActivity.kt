package com.example.bottomnavapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fragment1: Fragment = HomeFragment()
    private val fragment2: Fragment = ExploreFragment()
    private val fragment3: Fragment = PlaylistFragment()
    private val fragment4: Fragment = ProfileFragment()

    private val fragmentManager: FragmentManager = supportFragmentManager
    private var active: Fragment = fragment1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        fragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, fragment4, "4").hide(fragment4)
            add(R.id.fragment_container, fragment3, "3").hide(fragment3)
            add(R.id.fragment_container, fragment2, "2").hide(fragment2)
            add(R.id.fragment_container, fragment1, "1").commit()
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    fragmentManager.beginTransaction().hide(active).show(fragment1).commit()
                    active = fragment1
                    true
                }

                R.id.navigation_explore -> {
                    fragmentManager.beginTransaction().hide(active).show(fragment2).commit()
                    active = fragment2
                    true
                }

                R.id.navigation_playlist -> {
                    fragmentManager.beginTransaction().hide(active).show(fragment3).commit()
                    active = fragment3
                    true
                }

                R.id.navigation_profile -> {
                    fragmentManager.beginTransaction().hide(active).show(fragment4).commit()
                    active = fragment4
                    true
                }

                else -> false
            }
        }

    }
}