package com.example.daybite.Requests

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

//code by tom
class Requests
{
    fun GenerateBlurbFact(interest : String) : String {
        // initialize return node to null
        var blurbJson = String()
        //thread to access Internet on new thread
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
                //println(root.path(interest).asText())
                //Your code goes here
                blurbJson = root.findValue(interest).textValue()
            } catch (e: Exception)
            {
                e.printStackTrace()
            }
        }

        thread.start()
        thread.join()
        return blurbJson
    }
}