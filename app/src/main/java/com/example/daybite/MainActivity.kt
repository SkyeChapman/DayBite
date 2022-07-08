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


    var useNameInput : String = "" //username
    var passwordInput : String = "" //password
    var dateOfBirthMonth : Int = 0 //user dob month
    var dateOfBirthDay : Int = 0 //user dob day
    var dateOfBirthYear : Int = 0 // user dob year

}