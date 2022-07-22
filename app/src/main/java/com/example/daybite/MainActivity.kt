package com.example.daybite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView

//Select Your Interests

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: // figure out the binding for this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backButton = findViewById<TextView>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()

        }

        val createButton = findViewById<TextView>(R.id.createButton)
        createButton.setOnClickListener {


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


        }
    }






}