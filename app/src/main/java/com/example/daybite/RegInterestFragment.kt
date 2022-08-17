package com.example.daybite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.StorageReference


class RegInterestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_reg_interest, container, false)


        //back to register page
        view.findViewById<Button>(R.id.backBTN).setOnClickListener {
            val navy = activity as Navigator
            navy.fragNavigation(RegisterFragment(), false)
        }

        //back to login screen to make user reauthenicate
        view.findViewById<Button>(R.id.submitBTN).setOnClickListener {
            val intent = Intent(this@RegInterestFragment.requireContext(), MainLoginActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}