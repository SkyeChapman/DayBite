package com.example.daybite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daybite.Blurbs.Blurb
import com.example.daybite.Blurbs.BlurbAdapter
import com.example.daybite.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_feed.*

/**
 * A simple [Fragment] subclass.
 */
class FeedFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private lateinit var blurbAdapter: BlurbAdapter
    private lateinit var recyclerView: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feed, container, false)

        //Generate blurbs on feed fragment
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvMainfeed)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        blurbAdapter = BlurbAdapter(mutableListOf())

        //generate list of blurbs
        blurbAdapter.GenerateBlurbs()
        recyclerView.adapter = blurbAdapter



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

}