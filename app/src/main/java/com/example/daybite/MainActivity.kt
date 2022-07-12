package com.example.daybite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), Navigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.DayBite,LoginFragment())
            .commit()
    }

    override fun navigationfrag(fragment: Fragment, addToStack: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.DayBite,fragment)

        if(addToStack)
        {
            transaction.addToBackStack(null)

        }
        transaction.commit()

    }
}