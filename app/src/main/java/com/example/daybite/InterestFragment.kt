package com.example.daybite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class InterestFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_interest, container, false)

        view.findViewById<ImageButton>(R.id.logoutBtn).setOnClickListener {
            //Sign user out of account
            Firebase.auth.signOut()

            //Switch back to Login screen
            val intent = Intent(this@InterestFragment.requireContext(),MainLoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(context, "LogOut Successful", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}