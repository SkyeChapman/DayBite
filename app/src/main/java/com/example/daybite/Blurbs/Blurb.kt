
package com.example.daybite.Blurbs
//code by tom
import com.example.daybite.Requests.Requests
import kotlin.random.Random
import kotlin.random.nextUInt
import kotlin.time.measureTimedValue

enum class Interests(){
    Miscellaneous,
    Assorted,
    Random,
    UnSorted,
    Varied,
    Disordered,
    Scrambled,
    Different,
    Conglomerate,
    Diverse
}
class Blurb (){
    //members of class
    var mHeader = String()
    var mBody = String()
    var mIsFavorited: Boolean = false

    //mutators and accessors
    fun GetFactBody(): String {return mBody}
    fun GetFactInterest():String{return mHeader}
    fun GetFavorited():Boolean{return mIsFavorited}
    fun SetFactBody(body:String)
    {
        mBody = body
    }
    fun SetFactInterest(topic:String)
    {
        mHeader = topic
    }
    fun SetFavorite(checkBoxState:Boolean)
    {
        mIsFavorited = checkBoxState
    }
    fun GetRandomInterest():String
    {
        var retVal = String()
        val randomInterest = Random.nextInt(10)
        for (int in Interests.values())
        {
             retVal = Interests.values()[randomInterest].name
        }
        println(retVal)
        return retVal
    }
    //initializer
    init {
        //create API request
        val requests = Requests()
        //set API fact to Blurb body text
        this.SetFactBody(requests.GenerateBlurbFact("fact"))
        //set topic of blurb
        this.SetFactInterest(GetRandomInterest())
    }
}