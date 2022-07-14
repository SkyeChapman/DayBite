package com.example.daybite
//Account Setup
//
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.lang.ref.PhantomReference

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    //private lateinit var auth : FirebaseAuth
   // private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //auth = FirebaseAuth.getInstance()
        //val uid = auth.currentUser?.uid
        //databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        binding.NextButton.setOnClickListener {

            val firstName = binding.userName.text.ToString()
            val emailAddress = binding.userEmail.text.ToString()
            val password = binding.userPassword.text.ToString()
            val dateOfBirth = binding.userDateOfBirth.text.ToString()


            val user = User(firstName, emailAddress, password, dateOfBirth)

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




    }


   // var userNameInput : String = "" //username
   // var userEmailInput : String = "" // email
   // var passwordInput : String = "" //password
   // var dateOfBirth : Int = 0 //user dob


