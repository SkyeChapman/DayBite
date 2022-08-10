
package com.example.daybite.Blurbs
//code by tom
import com.example.daybite.Requests.Requests

class Blurb (){
    //members of class
    var mHeader = String()
    var mBody = String()
    //mutators and accessors
    fun GetFactBody(): String {return mBody}
    fun GetFactInterest():String{return mHeader}
    fun SetFactBody(body:String)
    {
        mBody = body
    }
    fun SetFactInterest(topic:String)
    {
        mHeader = topic
    }
    //initializer
    init {
        //create API request
        val requests = Requests()
        //set API fact to Blurb body text
        this.SetFactBody(requests.GenerateBlurbFact("fact"))
        //set topic of blurb
        this.SetFactInterest("Temporary Stand-in Interest")
    }
}