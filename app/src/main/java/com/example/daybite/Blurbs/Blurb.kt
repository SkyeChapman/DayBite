
package com.example.daybite.Blurbs
//code by tom
import android.provider.Settings.Global.getString
import android.widget.TextView
import com.example.daybite.R
import com.example.daybite.Requests.Requests
import org.w3c.dom.Text

class Blurb (){
    //members of class
    var mHeader: String = "topic"
    var mBody : String = "This is the body of the fact"
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
        this.SetFactBody(requests.GetCardFact("interest")!!.asText())
        //set topic of blurb
        this.SetFactInterest("Temporary Stand-in Interest")
    }
}