package com.example.daybite

import android.content.Intent
import android.os.Bundle
import android.view.View
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
import kotlinx.android.synthetic.main.blurb_item.*
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

        //Favorite Button

        tbFavoriteButton.setOnCheckedChangeListener { checkBox, isChecked ->
            if(isChecked)
            {
                showToast( "Added to Favorites")
            }
            else
            {
                showToast( "Removed from Favorites")
            }
        }
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

    private fun showToast(str: String)
    {
        Toast.makeText(this, str , Toast.LENGTH_SHORT).show()
    }



    //Code by Skye
    /*val backBTN = findViewById<TextView>(R.id.backButton).setOnClickListener {
        loadFragment(FeedFragment())
    }
    val createButton = findViewById<TextView>(R.id.createButton).setOnClickListener {

        val musicBox = findViewById<CheckBox>(R.id.musicCheckBox)
        val musicCheckBox = musicBox.isChecked
        val foodBox = findViewById<CheckBox>(R.id.foodCheckBox)
        val foodCheckBox = foodBox.isChecked
        val techBox = findViewById<CheckBox>(R.id.techCheckBox)
        val techCheckBox = techBox.isChecked
        val historyBox = findViewById<CheckBox>(R.id.historyCheckBox)
        val historyCheckBox = historyBox.isChecked
        val animalsBox = findViewById<CheckBox>(R.id.animalsCheckBox)
        val animalsCheckBox = animalsBox.isChecked
        val spaceBox = findViewById<CheckBox>(R.id.spaceCheckBox)
        val spaceCheckBox = spaceBox.isChecked
        val aquaticBox = findViewById<CheckBox>(R.id.aquaticCheckBox)
        val aquaticCheckBox = aquaticBox.isChecked
        val filmsBox = findViewById<CheckBox>(R.id.filmsCheckBox)
        val filmsCheckBox = filmsBox.isChecked
        val economicsBox = findViewById<CheckBox>(R.id.economicsCheckBox)
        val economicsCheckBox = economicsBox.isChecked
        val sportsBox = findViewById<CheckBox>(R.id.sportsCheckBox)
        val sportsCheckBox = sportsBox.isChecked

        fun createAccount(userCategories : ArrayList<Boolean>) {
            if (musicBox.isChecked) {
                userCategories.add(musicCheckBox)
            } else {
                //continue
            }
            if (foodBox.isChecked) {
                userCategories.add(foodCheckBox)
            } else {
                //do nothing
            }
            if (techBox.isChecked) {
                userCategories.add(techCheckBox)
            } else {
                //continue
            }
            if (historyBox.isChecked) {
                userCategories.add(historyCheckBox)
            } else {
                //what is the code for continue
            }
            if (animalsBox.isChecked) {
                userCategories.add(animalsCheckBox)
            } else {
                //i'll find it soon, do nothing
            }
            if (spaceBox.isChecked) {
                userCategories.add(spaceCheckBox)
            } else {
                //or else!
            }
            if (aquaticBox.isChecked) {
                userCategories.add(aquaticCheckBox)
            } else {
                //just ignore please
            }
            if (filmsBox.isChecked) {
                userCategories.add(filmsCheckBox)
            } else {
                //if it's not added, who cares!
            }
            if (economicsBox.isChecked) {
                userCategories.add(economicsCheckBox)
            } else {
                //do nothing, i'm kinda hungry
            }
            if (sportsBox.isChecked) {
                userCategories.add(sportsCheckBox)
            } else {
                //leave me alone
            }
            val newCreateAccount = User(categoryChoiceArray = userCategories)
            newCreateAccount.categoryChoiceArray.contains(true).toString()
        }
    }*/
}












