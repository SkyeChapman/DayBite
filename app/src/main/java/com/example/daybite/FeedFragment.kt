package com.example.daybite

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.daybite.Blurbs.BlurbAdapter
import com.example.daybite.databinding.ActivityFeedBinding
import com.example.daybite.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 */
class FeedFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private lateinit var blurbAdapter: BlurbAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        
        view.findViewById<ImageButton>(R.id.logoutBtn).setOnClickListener {
            //Sign user out of account
            Firebase.auth.signOut()

            //Switch back to Login screen
            val intent = Intent(this@FeedFragment.requireContext(),MainLoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(context, "LogOut Successful",Toast.LENGTH_SHORT).show()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}