package com.example.daybite.Requests

import com.example.daybite.ui.Card
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.json.JSONObject
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


class Requests
{
    public fun GetCardFact( interest : String)
    {
        val thread = Thread{
            try
            {
                //url to fetch data from
                val url = URL("https://api.api-ninjas.com/v1/facts?limit=1")
                //create connection
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                //accept data as JSON
                connection.setRequestProperty("accept", "application/json")
                //input api_Key
                connection.addRequestProperty("X-API-Key", "jWJb+UsA874dX+N7U7dpcw==bePxXfEJvhmVjonG")
                val responseStream: InputStream = connection.getInputStream()
                val mapper = ObjectMapper()
                val root: JsonNode = mapper.readTree(responseStream)
                println(root.path("fact").asText())
                //Your code goes here
            } catch (e: Exception)
            {
                e.printStackTrace()
            }
        }

        thread.start()

    }
    fun ConvertFactJSON(json:JSONObject) {

    }
}