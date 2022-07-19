package com.example.daybite
//Account Setup
//
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.SaveInfo
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.savedstate.SavedStateRegistry
import java.lang.ref.PhantomReference
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivity
    //private lateinit var auth : FirebaseAuth
    // private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding = MainActivity().binding.


        setContentView(R.layout.activity_main)

        //auth = FirebaseAuth.getInstance()
        //val uid = auth.currentUser?.uid
        //databaseReference = FirebaseDatabase.getInstance().getReference("Users")


        //Next Button, create user info
        val nextButton = findViewById<TextView>(R.id.nextButton)
        nextButton.setOnClickListener {
            val userNameInput = findViewById<TextView>(R.id.userName)
            val userName = userNameInput.text.toString()
            val emailInput = findViewById<TextView>(R.id.userEmail)
            val userEmail = emailInput.text.toString()
            val passwordInput = findViewById<TextView>(R.id.userPassword)
            val userPassword = passwordInput.text.toString()
            val dateOfBirthInput = findViewById<TextView>(R.id.userDateOfBirth)
            val userDateOfBirth = dateOfBirthInput.inputType.toInt()
            val nightModeInput = findViewById<TextView>(R.id.darkModeSwitch)
            val userNightModeSwitch = nightModeInput.isActivated
            val notificationInput = findViewById<TextView>(R.id.notificationsSwitch)
            val userNotificationSwitch = notificationInput.isActivated


            val userAccount = User(userName, userEmail, userPassword, userDateOfBirth, userNightModeSwitch, userNotificationSwitch)
            //save userAccount?
            // android.service.autofill.SaveInfo.SAVE_DATA_TYPE_USERNAME  //?

        }


        //Back Button, returns to previous screen
        val backButton = findViewById<TextView>(R.id.backButton)
        backButton.setOnClickListener {

            onBackPressed()
            //finish()

        }





            // if(uid != null)
            //  {
            //databaseReference.child(uid).setValue(user).addOnCompleteListener {

            // if(it.isSuccessful)
            //  {

            //  }
            // else
            //  {
            //  Toast.makeText(context: this@MainActivity, text "Failed to update profile", Toast.LENGTH_SHORT).show()

            // }
            // }
        }
    }









