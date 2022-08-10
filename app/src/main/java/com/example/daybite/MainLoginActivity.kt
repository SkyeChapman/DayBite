package com.example.daybite

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.example.daybite.databinding.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_account.firstName
import kotlinx.android.synthetic.main.fragment_account.lastName
import kotlinx.android.synthetic.main.fragment_register.*

class MainLoginActivity() : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bindFrag:FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseRef : DatabaseReference
    private lateinit var storageRef : StorageReference
    private lateinit var profilePic : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        bindFrag = FragmentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        bindFrag.submitBTN.setOnClickListener {

            //get user info
            val fName = bindFrag.firstName.text.toString()
            val lName = bindFrag.lastName.text.toString()
            val _email = bindFrag.regEmail.text.toString()
            val _age = bindFrag.age.text.length
            val _password = bindFrag.setPassword.text.toString()

            databaseRef = FirebaseDatabase.getInstance().getReference("Users")
            val user = UserProfile(fName,lName,_email,_password,_age)
            databaseRef.child(fName).setValue(user).addOnSuccessListener {

                bindFrag.firstName.text.clear()
                bindFrag.lastName.text.clear()
                bindFrag.regEmail.text.clear()
                bindFrag.setPassword.text.clear()
                bindFrag.age.text.clear()

                val intent = Intent(this, MainLoginActivity::class.java)
                startActivity(intent)
            }

        }

        //Validate user on button click
        binding.loginBTN.setOnClickListener {
            validateEmptyForm()
        }
        //Switch to forgot password frag on button click
        binding.forgotBTN.setOnClickListener {
            fragNavigation(ForgotPasswordFragment(), false)
        }
        //switch to registration page on button click
        binding.regBTN.setOnClickListener {
            fragNavigation(RegisterFragment(), false)
        }
    }

//method for fragment transaction
    override fun fragNavigation(fragment: Fragment, addToStack: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.dayBite, fragment)
        if(addToStack){
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
 //method for validation thru firebase
    private fun validateEmptyForm()
    {
        val warning = AppCompatResources.getDrawable(this,R.drawable.ic_baseline_warning_24)
        warning?.setBounds(0,0,warning.intrinsicWidth, warning.intrinsicHeight)

        when
        {
            TextUtils.isEmpty(logNUSER.text.toString().trim())->
            {
                logNUSER.setError("Please enter Username/Email",warning)
            }
            TextUtils.isEmpty(logNPass.text.toString().trim())->
            {
                logNPass.setError("Please enter Password",warning)
            }

            logNUSER.text.toString().isNotEmpty()&&
                    logNPass.text.toString().isNotEmpty()->
            {
                if(logNUSER.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")))
                {
                    if(logNPass.text.toString().length >= 6){

                        //Check if current user in firebase database
                        val email: String = logNUSER.text.toString().trim(){it <= ' '}
                        val password: String = logNPass.text.toString().trim(){it <= ' '}

                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val firbaseUser: FirebaseUser = task.result!!.user!!
                                    Toast.makeText(this,"Login Successful",
                                        Toast.LENGTH_SHORT)
                                        .show()

                                    //switch to New Activity
                                    val intent = Intent(this,FeedActivity::class.java)
                                    startActivity(intent)

                                }
                                else //Login Failure
                                {
                                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                                        .addOnFailureListener { e->
                                            Toast.makeText(this,"Login Failed!, ${e.message}",
                                                Toast.LENGTH_SHORT).show()
                                        }
                                }
                            }
                    }
                    else{
                        logNPass.setError("Reminder:: Passwords are at least 6 characters", warning)
                    }
                }
                else
                {
                    logNUSER.setError("Please enter a valid email address", warning)
                }
            }
        }
    }
//method ofr uploading and changing profile pictures
    private fun uploadPic(){

        profilePic = Uri.parse("android.resource://$packageName/${R.drawable.profile_pic}")
        storageRef = FirebaseStorage.getInstance().getReference("Users/"+auth.currentUser?.uid)
        storageRef.putFile(profilePic).addOnCompleteListener {

            Toast.makeText(this,"Profile pic added",Toast.LENGTH_SHORT).show()

        }
            .addOnFailureListener {

            Toast.makeText(this, "Unable to add Picture!!",Toast.LENGTH_SHORT).show()
        }

    }
    private fun emptyFormRegister()
    {
        val warning = AppCompatResources.getDrawable(this, R.drawable.ic_baseline_warning_24)
        warning?.setBounds(0,0,warning.intrinsicWidth, warning.intrinsicHeight)

        //Check if field is empty
        when {
            TextUtils.isEmpty(firstName.text.toString().trim()) -> {
                firstName.setError("Please enter First Name", warning)
            }
            TextUtils.isEmpty(lastName.text.toString().trim()) -> {
                lastName.setError("Please enter Last Name", warning)
            }
            TextUtils.isEmpty(regEmail.text.toString().trim()) -> {
                regEmail.setError("Please enter a valid email address", warning)
            }
            TextUtils.isEmpty(setPassword.text.toString().trim()) -> {
                setPassword.setError("Must enter password", warning)
            }
            TextUtils.isEmpty(confirmPass.text.toString().trim()) -> {
                confirmPass.setError("Must enter password", warning)
            }
            regEmail.text.toString().isNotEmpty()&&
                    setPassword.text.toString().isNotEmpty()&&
                    confirmPass.text.toString().isNotEmpty()->
            {
                if(regEmail.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")))
                {
                    if(setPassword.text.toString().length>=6)
                    {
                        if(setPassword.text.toString() == confirmPass.text.toString())
                        {

                            val email: String = regEmail.text.toString().trim(){it <= ' '}
                            val password: String = setPassword.text.toString().trim(){it <= ' '}
                            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        val firbaseUser: FirebaseUser = task.result!!.user!!
                                        Toast.makeText(this,"Register Successful",
                                            Toast.LENGTH_SHORT)
                                            .show()
                                        val intent = Intent(this,MainLoginActivity::class.java)
                                        startActivity(intent)
                                    }
                                }
                        }
                        else
                        {
                            confirmPass.setError("Passwords do not match", warning)
                        }
                    }
                    else
                    {
                        setPassword.setError("Must be at least 6 Character's",warning)
                    }
                }
                else
                {
                    regEmail.setError("Please enter a Valid email address", warning)
                }

            }
        }
    }
}
