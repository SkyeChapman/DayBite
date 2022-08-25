package com.example.daybite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daybite.Blurbs.BlurbAdapter
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ExploreFragment : Fragment() {

    private lateinit var blurbAdapter: BlurbAdapter
    private lateinit var recyclerView: RecyclerView

       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        //code by tom and ap
        //generate blurbs for feed
        val layoutManager = LinearLayoutManager(context)
        recyclerView= view.findViewById(R.id.rvMainfeed2)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        //generate adapter for blurbs
        blurbAdapter = BlurbAdapter(mutableListOf())
        //generate list of blurbs
        blurbAdapter.GenerateBlurbs()
        recyclerView.adapter = blurbAdapter


        return view
    }
}