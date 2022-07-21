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
        backButton.setOnClickListener() {
            onBackPressed()

        }

        val createButton = findViewById<TextView>(R.id.createButton)
        createButton.setOnClickListener() {

        }
    }

    val musicBox = findViewById<CheckBox>(R.id.musicCheckBox)
    var musicCheckBox = musicBox.isChecked.equals(null)
    val foodBox = findViewById<CheckBox>(R.id.foodCheckBox)
    var foodCheckBox = foodBox.isChecked.equals(null)
    val techBox = findViewById<CheckBox>(R.id.techCheckBox)
    var techCheckBox = techBox.isChecked.equals(null)
    val historyBox = findViewById<CheckBox>(R.id.historyCheckBox)
    var historyCheckBox = historyBox.isChecked.equals(null)
    val animalsBox = findViewById<CheckBox>(R.id.animalsCheckBox)
    var animalsCheckBox = animalsBox.isChecked.equals(null)
    val spaceBox = findViewById<CheckBox>(R.id.spaceCheckBox)
    var spaceCheckBox = spaceBox.isChecked.equals(null)
    val aquaticBox = findViewById<CheckBox>(R.id.aquaticCheckBox)
    val aquaticCheckBox = aquaticBox.isChecked.equals(null)
    val filmsBox = findViewById<CheckBox>(R.id.filmsCheckBox)
    var filmsCheckBox = filmsBox.isChecked.equals(null)
    val economicsBox = findViewById<CheckBox>(R.id.economicsCheckBox)
    var economicsCheckBox = economicsBox.isChecked.equals(null)
    val sportsBox = findViewById<CheckBox>(R.id.sportsCheckBox)
    val sportsCheckBox = sportsBox.isChecked.equals(null)


    var userCategories : ArrayList<Boolean> ?= null

    fun createAccount(categoryArray : ArrayList<Boolean>) {
        if (musicBox.isActivated) {
            userCategories?.add(musicCheckBox)

        } else {

        }
        if (foodBox.isActivated) {
            userCategories?.add(foodCheckBox)
        } else {

        }
        if (techBox.isActivated) {
            userCategories?.add(techCheckBox)
        } else {

        }
        if (historyBox.isActivated) {
            userCategories?.add(historyCheckBox)
        } else {

        }
        if (animalsBox.isActivated) {
            userCategories?.add(animalsCheckBox)
        } else {

        }
        if (spaceBox.isActivated) {
            userCategories?.add(spaceCheckBox)
        } else {

        }
        if (aquaticBox.isActivated) {
            userCategories?.add(aquaticCheckBox)
        } else {

        }
        if (filmsBox.isActivated) {

        }
    }




}