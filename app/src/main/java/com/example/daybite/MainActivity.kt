package com.example.daybite
//Account Setup
//
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    var userNameInput : String = "" //username
    var userEmailInput : String = "" // email
    var passwordInput : String = "" //password
    var dateOfBirth : Int = 0 //user dob


}