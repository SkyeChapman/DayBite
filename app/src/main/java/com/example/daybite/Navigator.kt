package com.example.daybite

import androidx.fragment.app.Fragment

interface Navigator {
    fun fragNavigation(fragment: Fragment, addToStack: Boolean)
}