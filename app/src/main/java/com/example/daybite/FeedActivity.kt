package com.example.daybite

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daybite.Blurbs.BlurbAdapter
import com.example.daybite.databinding.ActivityFeedBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_feed.*

//Select Your Interests

class FeedActivity : AppCompatActivity(){
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var binding: ActivityFeedBinding
    //private lateinit var binding: // figure out the binding for this
    private lateinit var blurbAdapter: BlurbAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //generate adapter for blurbs
        blurbAdapter = BlurbAdapter(mutableListOf())
        //generate list of blurbs
        blurbAdapter.GenerateBlurbs()
        rvMainfeed.adapter = blurbAdapter
        rvMainfeed.layoutManager = LinearLayoutManager(this)

        //code by kris & Ap
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FeedFragment())
            .commit()
        bottomNav = findViewById(R.id.bottomNavigationView2)
        bottomNav.setOnItemSelectedListener(navListener)
    }
    val navListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when (it.itemId) {
            R.id.feed -> {
                loadFragment(FeedFragment())
            }
            R.id.explore -> {
                loadFragment(ExploreFragment())
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
//code by kris
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    //Code by Skye
    /*val backBTN = findViewById<TextView>(R.id.backButton).setOnClickListener {
        loadFragment(FeedFragment())
    }
    val createButton = findViewById<TextView>(R.id.createButton).setOnClickListener {

        val musicBox = findViewById<CheckBox>(R.id.Miscellaneous)
        val Miscellaneous = musicBox.isChecked
        val foodBox = findViewById<CheckBox>(R.id.cbAssorted)
        val cbAssorted = foodBox.isChecked
        val techBox = findViewById<CheckBox>(R.id.cbRandom)
        val cbRandom = techBox.isChecked
        val historyBox = findViewById<CheckBox>(R.id.cbUnSorted)
        val cbUnSorted = historyBox.isChecked
        val animalsBox = findViewById<CheckBox>(R.id.cbVaried)
        val cbVaried = animalsBox.isChecked
        val spaceBox = findViewById<CheckBox>(R.id.cbDisordered)
        val cbDisordered = spaceBox.isChecked
        val aquaticBox = findViewById<CheckBox>(R.id.cbConglomerate)
        val cbConglomerate = aquaticBox.isChecked
        val filmsBox = findViewById<CheckBox>(R.id.cbDifferent)
        val cbDifferent = filmsBox.isChecked
        val economicsBox = findViewById<CheckBox>(R.id.cbDiverse)
        val cbDiverse = economicsBox.isChecked
        val sportsBox = findViewById<CheckBox>(R.id.cbScrambled)
        val cbScrambled = sportsBox.isChecked

        fun createAccount(userCategories : ArrayList<Boolean>) {
            if (musicBox.isChecked) {
                userCategories.add(Miscellaneous)
            } else {
                //continue
            }
            if (foodBox.isChecked) {
                userCategories.add(cbAssorted)
            } else {
                //do nothing
            }
            if (techBox.isChecked) {
                userCategories.add(cbRandom)
            } else {
                //continue
            }
            if (historyBox.isChecked) {
                userCategories.add(cbUnSorted)
            } else {
                //what is the code for continue
            }
            if (animalsBox.isChecked) {
                userCategories.add(cbVaried)
            } else {
                //i'll find it soon, do nothing
            }
            if (spaceBox.isChecked) {
                userCategories.add(cbDisordered)
            } else {
                //or else!
            }
            if (aquaticBox.isChecked) {
                userCategories.add(cbConglomerate)
            } else {
                //just ignore please
            }
            if (filmsBox.isChecked) {
                userCategories.add(cbDifferent)
            } else {
                //if it's not added, who cares!
            }
            if (economicsBox.isChecked) {
                userCategories.add(cbDiverse)
            } else {
                //do nothing, i'm kinda hungry
            }
            if (sportsBox.isChecked) {
                userCategories.add(cbScrambled)
            } else {
                //leave me alone
            }
            val newCreateAccount = User(categoryChoiceArray = userCategories)
            newCreateAccount.categoryChoiceArray.contains(true).toString()
        }
    }*/
}












