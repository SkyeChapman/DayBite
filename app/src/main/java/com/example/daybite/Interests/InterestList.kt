package com.example.daybite.Interests

import com.example.daybite.Blurbs.Blurb

data class InterestList(var interest : String)
{
    lateinit var interestList : MutableList<Blurb>
    fun GetInterest(): String {return interest}

    fun AddBlurbtoList(checkBlurbInterest : Blurb)
    {
        if (interest == checkBlurbInterest.GetFactInterest())
            interestList.add(checkBlurbInterest)
        else
        {
            val tempInterest = InterestList(checkBlurbInterest.GetFactInterest())
            tempInterest.interestList.add(checkBlurbInterest)
        }
    }
}
