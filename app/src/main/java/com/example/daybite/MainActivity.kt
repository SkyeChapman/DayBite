package com.example.daybite

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.daybite.ui.Blurb
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView
    private var blurbBody:TextView = findViewById(R.id.blurb_body) as TextView
    private var blurbHeader:TextView = findViewById(R.id.blurb_title) as TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(FeedFragment())
        bottomNav = findViewById(R.id.bottomNavigationView2) as BottomNavigationView
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.feed -> {
                    loadFragment(FeedFragment())
                }
                R.id.favorites -> {
                    loadFragment(FavoritesFragment())
                }
                R.id.interests -> {
                    loadFragment(InterestFragment())
                }
                R.id.account -> {
                    loadFragment(AccountFragment())
                }
            }
            true
        }

        val blurb = Blurb()
        blurbBody.text = blurb.GetFactBody()
        blurbHeader.text = blurb.GetFactInterest()
    }


    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
