package com.example.daybite

import com.example.daybite.Interests.InterestList

class User()
{
    lateinit var categoryChoiceArray: ArrayList<String>

    fun SaveInterestsToUser()
    {
        for (choice in categoryChoiceArray)
        {
            val interestList = InterestList(choice)
        }
    }
}
