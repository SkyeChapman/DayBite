package com.example.daybite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlin.concurrent.timerTask
import kotlinx.coroutines.delay as delay1

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handle = Handler()
        handle.postDelayed({delayScreen()
        },2500)




    }
    private fun delayScreen(){
        val intent = Intent(this,MainLoginActivity::class.java)
        startActivity(intent)
    }
}