package com.example.daybite.Interests

import com.example.daybite.Blurbs.Blurb

data class InterestList(var interest : String,var blurbToBeSaved : Blurb)
{
    lateinit var interestList : MutableList<Blurb>
    fun GetInterest(): String {return interest}

    fun AddBlurbtoList(checkBlurbInterest : Blurb)
    {
        if (interest == blurbToBeSaved.GetFactInterest())
            interestList.add(blurbToBeSaved)
        else
        {
            val tempInterest = InterestList(blurbToBeSaved.GetFactInterest(),blurbToBeSaved)
            tempInterest.interestList.add(blurbToBeSaved)
        }
    }
}
