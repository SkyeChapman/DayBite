package com.example.daybite.ui

import com.example.daybite.Requests.Requests
import com.fasterxml.jackson.databind.JsonNode
import org.json.JSONObject

class Card (){
    init {
        val requests = Requests()
        requests.GetCardFact("interest")
    }
}
