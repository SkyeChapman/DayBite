package com.example.daybite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.daybite.databinding.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainLoginActivity() : AppCompatActivity(), Navigator {

    private lateinit var bottomNav : BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private lateinit var feedBind : FragmentFeedBinding
    private lateinit var acctBind : FragmentAccountBinding
    private lateinit var faveBind : FragmentFavoritesBinding
    private lateinit var intBind : FragmentInterestBinding
    private lateinit var logBind : FragmentLoginBinding
    private lateinit var regBind : FragmentRegisterBinding
    private lateinit var forgtpassBind : FragmentForgotPasswordBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun fragNavigation(fragment: Fragment, addToStack: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.main, fragment)
        if(addToStack){
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}