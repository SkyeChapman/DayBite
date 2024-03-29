package com.example.daybite

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Window
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.example.daybite.databinding.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*


class MainLoginActivity() : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bindFrag:FragmentRegisterBinding
    private lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        bindFrag = FragmentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Validate user on button click
        binding.loginBTN.setOnClickListener {
            progressBar()
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
                hideProgressBar()
                logNUSER.setError("Please enter Username/Email",warning)

            }
            TextUtils.isEmpty(logNPass.text.toString().trim())->
            {
                hideProgressBar()
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
                                    //dismiss progress bar
                                    hideProgressBar()

                                    val firebaseUser: FirebaseUser = task.result!!.user!!
                                    Toast.makeText(this,"Login Successful",
                                        Toast.LENGTH_SHORT)
                                        .show()



                                    //switch to New Activity
                                    val intent = Intent(this,FeedActivity::class.java)
                                    startActivity(intent)

                                }
                                else //Login Failure
                                {
                                    hideProgressBar()
                                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                                        .addOnFailureListener { e->
                                            Toast.makeText(this,"Login Failed!, ${e.message}",
                                                Toast.LENGTH_SHORT).show()

                                        }
                                }
                            }
                    }
                    else{
                        hideProgressBar()
                        logNPass.setError("Reminder:: Passwords are at least 6 characters", warning)
                    }
                }
                else
                {
                    hideProgressBar()
                    logNUSER.setError("Please enter a valid email address", warning)
                }
            }
        }
    }

//show progress bar
    private fun progressBar(){
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.progress_dialog)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }

    //method to hide progress bar
    private fun hideProgressBar(){
        dialog.dismiss()
    }

}
