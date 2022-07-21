package com.example.daybite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

//Select Your Interests

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: // figure out the binding for this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val musicBox = findViewById<TextView>(R.id.musicCheckBox)
    var musicCheckBox = musicBox.isActivated.equals(null)
    val foodBox = findViewById<TextView>(R.id.foodCheckBox)
    var foodCheckBox = foodBox.isActivated.equals(null)
    val techBox = findViewById<TextView>(R.id.techCheckBox)
    var techCheckBox = techBox.isActivated.equals(null)
    val historyBox = findViewById<TextView>(R.id.historyCheckBox)
    var historyCheckBox = historyBox.isActivated.equals(null)
    val animalsBox = findViewById<TextView>(R.id.animalsCheckBox)
    var animalsCheckBox = animalsBox.isActivated.equals(null)
    val spaceBox = findViewById<TextView>(R.id.spaceCheckBox)
    var spaceCheckBox = spaceBox.isActivated.equals(null)
    val aquaticBox = findViewById<TextView>(R.id.aquaticCheckBox)
    val aquaticCheckBox = aquaticBox.isActivated.equals(null)
    val filmsBox = findViewById<TextView>(R.id.filmsCheckBox)
    val filmsCheckBox = filmsBox.isActivated.equals(null)
    val economicsBox = findViewById<TextView>(R.id.economicsCheckBox)
    val economicsCheckBox = economicsBox.isActivated.equals(null)
    val sportsBox = findViewById<TextView>(R.id.sportsCheckBox)
    val sportsCheckBox = sportsBox.isActivated.equals(null)

}