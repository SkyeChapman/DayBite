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
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var cancel =  inflater.inflate(R.layout.fragment_register, container, false)

        cancel.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            var navCreate = activity as Navigation
            navCreate.navigationfrag(LoginFragment(), false)
        }
        return cancel
    }
}