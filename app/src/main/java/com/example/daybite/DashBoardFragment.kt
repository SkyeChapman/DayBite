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
class DashBoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_dash_board, container, false)
        view.findViewById<Button>(R.id.logOUT).setOnClickListener {
            val navReg = activity as Navigator
            navReg.fragNavigation(LoginFragment(), false)
        }
        return view
    }
}