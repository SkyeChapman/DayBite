package com.example.daybite.ui

import com.example.daybite.Requests.Requests
import com.fasterxml.jackson.databind.JsonNode
import org.json.JSONObject

class Card (){
    var mHeader: String = "topic"
    var mBody :String = "This is the body of the fact"


    init {
        val requests = Requests()
        requests.GetCardFact("interest")
    }
}
