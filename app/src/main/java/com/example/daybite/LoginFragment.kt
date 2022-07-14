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
class LoginFragment : Fragment() {

    private lateinit var log_user: EditText
    private lateinit var log_pass: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var login =  inflater.inflate(R.layout.fragment_login, container, false)
        log_user = login.findViewById(R.id.username)
        log_pass = login.findViewById(R.id.password)
        login.findViewById<Button>(R.id.createAcct).setOnClickListener {
            var navCreate = activity as Navigation
            navCreate.navigationfrag(RegisterFragment(), false)
        }
        login.findViewById<Button>(R.id.loginBTN).setOnClickListener {
            validateEmptyForm()
        }

        return login
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
                    Toast.makeText(context,"Login Successful", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    log_user.setError("Please enter a valid email address", warning)
                }
            }
        }
    }
}