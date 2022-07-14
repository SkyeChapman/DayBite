package com.example.daybite

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.content.res.AppCompatResources

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    private lateinit var fName: EditText
    private lateinit var lName: EditText
    private lateinit var reguserName: EditText
    private lateinit var regAge: EditText
    private lateinit var regEmail: EditText
    private lateinit var passWord: EditText
    private lateinit var cnfPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var reg =  inflater.inflate(R.layout.fragment_register, container, false)
        fName = reg.findViewById(R.id.firstName)
        lName = reg.findViewById(R.id.lastName)
        reguserName = reg.findViewById(R.id.reg_userName)
        regEmail = reg.findViewById(R.id.email)
        passWord = reg.findViewById(R.id.password)
        cnfPassword = reg.findViewById(R.id.passwordSet)


        reg.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            var navCreate = activity as Navigation
            navCreate.navigationfrag(LoginFragment(), false)
        }

        reg.findViewById<Button>(R.id.reg_BTN).setOnClickListener {
            validateEmptyForm()
        }
        return reg
    }
    private fun validateEmptyForm()
    {
        val warning = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_baseline_warning_24)
        warning?.setBounds(0,0,warning.intrinsicWidth, warning.intrinsicHeight)

        when
        {
            TextUtils.isEmpty(fName.text.toString().trim())->{
                fName.setError("Please enter First Name",warning)
            }
            TextUtils.isEmpty(lName.text.toString().trim())->{
                lName.setError("Please enter Last Name",warning)
            }
            TextUtils.isEmpty(reguserName.text.toString().trim())->{
                reguserName.setError("Please enter a Username",warning)
            }
            TextUtils.isEmpty(regEmail.text.toString().trim())->{
                regEmail.setError("Please enter a valid email address",warning)
            }
            TextUtils.isEmpty(passWord.text.toString().trim())->{
                passWord.setError("Must enter password",warning)
            }
            TextUtils.isEmpty(cnfPassword.text.toString().trim())->{
                cnfPassword.setError("Must enter password",warning)
            }
        }
    }
}