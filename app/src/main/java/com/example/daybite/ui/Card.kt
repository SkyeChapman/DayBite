package com.example.daybite.ui

import com.fasterxml.jackson.databind.JsonNode
import org.json.JSONObject

class Card (val factJSON: JsonNode){
    init {
        println(factJSON.path("Interest").asText())
    }
}
