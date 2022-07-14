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

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    private lateinit var fName: EditText
    private lateinit var lName: EditText
    private lateinit var regEmail: EditText
    private lateinit var regPassword: EditText
    private lateinit var cnfPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_register, container, false)
        fName = view.findViewById(R.id.firstName)
        lName = view.findViewById(R.id.lastName)
        regEmail = view.findViewById(R.id.email)
        regPassword = view.findViewById(R.id.passwordSet)
       cnfPassword = view.findViewById(R.id.passConfirm)


        view.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            var navCreate = activity as Navigation
            navCreate.navigationfrag(LoginFragment(), false)
        }

        view.findViewById<Button>(R.id.reg_BTN).setOnClickListener {
            validateEmptyForm()
        }
        return view
    }
    private fun validateEmptyForm()
    {
        val warning = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_baseline_warning_24)
        warning?.setBounds(0,0,warning.intrinsicWidth, warning.intrinsicHeight)

        when
        {
            TextUtils.isEmpty(fName.text.toString().trim())->
            {
                fName.setError("Please enter First Name",warning)
            }
            TextUtils.isEmpty(lName.text.toString().trim())->
            {
                lName.setError("Please enter Last Name",warning)
            }
            TextUtils.isEmpty(regEmail.text.toString().trim())->
            {
                regEmail.setError("Please enter a valid email address",warning)
            }
            TextUtils.isEmpty(regPassword.text.toString().trim())->
            {
                regPassword.setError("Must enter password",warning)
            }
            TextUtils.isEmpty(cnfPassword.text.toString().trim())->
            {
                cnfPassword.setError("Must enter password",warning)
            }

                    regEmail.text.toString().isNotEmpty()&&
                    regPassword.text.toString().isNotEmpty()&&
                    cnfPassword.text.toString().isNotEmpty()->
            {
                if(regEmail.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")))
                {
                    if(regPassword.text.toString().length>=6)
                    {
                        if(regPassword.text.toString() == cnfPassword.text.toString())
                        {
                            Toast.makeText(context,"Register Successful", Toast.LENGTH_SHORT).show()
                        }
                        else
                        {
                            cnfPassword.setError("Passwords do not match", warning)
                        }
                    }
                    else
                    {
                        regPassword.setError("Password most be at LEAST 6 characters",warning)
                    }
                }
                else
                {
                    regEmail.setError("Please enter a valid Email", warning)
                }
            }
        }
    }
}