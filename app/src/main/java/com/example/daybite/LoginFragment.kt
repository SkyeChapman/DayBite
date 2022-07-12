package com.example.daybite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var register =  inflater.inflate(R.layout.fragment_login, container, false)
        register.findViewById<Button>(R.id.createAcct).setOnClickListener {
            var navCreate = activity as Navigation
            navCreate.navigationfrag(RegisterFragment(), false)
        }
        return register
    }
}