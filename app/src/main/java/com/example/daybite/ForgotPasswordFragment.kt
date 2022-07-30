package com.example.daybite

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.google.firebase.auth.FirebaseAuth


/**
 * A simple [Fragment] subclass.
 */
class ForgotPasswordFragment : Fragment() {

    private lateinit var forgotEmail: EditText
    private lateinit var back:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_forgot_password, container, false)

        //Read in edit text
        forgotEmail = view.findViewById(R.id.forgotEmail)

        view.findViewById<Button>(R.id.cancelForgot).setOnClickListener {
            val navy = activity as Navigator
            navy.fragNavigation(LoginFragment(), false)
        }

        view.findViewById<Button>(R.id.passwordLinkBTN).setOnClickListener {
            validateEntry()
        }

        return view
    }
    private fun validateEntry()
    {
        //Add warning Icon with message
        val warning = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_baseline_warning_24)
        warning?.setBounds(0,0,warning.intrinsicWidth, warning.intrinsicHeight)

        when {
            TextUtils.isEmpty(forgotEmail.text.toString().trim()) -> {
                forgotEmail.setError("Please enter a valid email address", warning)
            }
            forgotEmail.text.toString().isNotEmpty()->
                {
                    if(forgotEmail.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")))
                    {
                        val navy = activity as Navigator
                        val email: String = forgotEmail.text.toString().trim(){it <= ' '}
                        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                            .addOnCompleteListener { task ->
                                if(task.isSuccessful)
                                {
                                    Toast.makeText(context, "Email sent successfully to reset password", Toast.LENGTH_LONG).show()
                                    //Switch back to Login Screen
                                    navy.fragNavigation(LoginFragment(), false)
                                }
                                else
                                {
                                    Toast.makeText(context,task.exception!!.toString(), Toast.LENGTH_LONG).show()
                                }
                            }

                    }
                    else
                    {
                        Toast.makeText(context,"Please use email format..[johndoe@email.Com",Toast.LENGTH_LONG).show()
                    }
                }


        }


    }

}