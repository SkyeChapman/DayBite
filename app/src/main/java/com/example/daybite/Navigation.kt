package com.example.daybite

import androidx.fragment.app.Fragment

interface Navigation {
    fun navigationfrag(fragment: Fragment, addToStack: Boolean)
}