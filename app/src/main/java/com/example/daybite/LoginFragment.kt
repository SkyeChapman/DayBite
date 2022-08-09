package com.example.daybite

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    //variables
    private lateinit var log_user: EditText
    private lateinit var log_pass: EditText
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment - Switch Screens!
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        log_user = view.findViewById(R.id.logNUSER)
        log_pass = view.findViewById(R.id.logNPass)

        view.findViewById<Button>(R.id.regBTN).setOnClickListener {
            val navy = activity as Navigator
            navy.fragNavigation(RegisterFragment(), false)
        }
        view.findViewById<Button>(R.id.loginBTN).setOnClickListener {
            validateEmptyForm()
        }
        view.findViewById<Button>(R.id.forgotBTN).setOnClickListener {
            val navy = activity as Navigator
            navy.fragNavigation(ForgotPasswordFragment(), false)
        }

        return view
    }


    private fun validateEmptyForm()
    {
        val warning = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_baseline_warning_24)
        warning?.setBounds(0,0,warning.intrinsicWidth, warning.intrinsicHeight)

        when
        {
            TextUtils.isEmpty(log_user.text.toString().trim())->
            {
                log_user.setError("Please enter Username/Email",warning)
            }
            TextUtils.isEmpty(log_pass.text.toString().trim())->
            {
                log_pass.setError("Please enter Password",warning)
            }

            log_user.text.toString().isNotEmpty()&&
                    log_pass.text.toString().isNotEmpty()->
            {
                if(log_user.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")))
                {
                    if(log_pass.text.toString().length >= 6){

                        //Check if current user in firebase database
                        val email: String = log_user.text.toString().trim(){it <= ' '}
                        val password: String = log_pass.text.toString().trim(){it <= ' '}
                        val navy = activity as Navigator
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val firebaseUser: FirebaseUser = task.result!!.user!!
                                    Toast.makeText(context,"Login Successful",
                                        Toast.LENGTH_SHORT)
                                        .show()
                                    navy.fragNavigation(DashBoardFragment(), false)
                                }
                                else //Login Failure
                                {
                                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                                        .addOnFailureListener { e->
                                            Toast.makeText(context,"Login Failed!, ${e.message}",
                                                Toast.LENGTH_SHORT).show()
                                        }
                                }
                            }
                    }
                    else{
                        log_pass.setError("Reminder:: Passwords are at least 6 characters", warning)
                    }
                }
                else
                {
                    log_user.setError("Please enter a valid email address", warning)
                }
            }
        }
    }
}