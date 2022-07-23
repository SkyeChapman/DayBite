
package com.example.daybite.ui

import android.provider.Settings.Global.getString
import android.widget.TextView
import com.example.daybite.R
import com.example.daybite.Requests.Requests
import org.w3c.dom.Text

class Blurb (){
    var mHeader: String = "topic"
    var mBody : String = "This is the body of the fact"
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

    init {
        val requests = Requests()
        this.SetFactBody(requests.GetCardFact("interest")!!.asText())
    }
}