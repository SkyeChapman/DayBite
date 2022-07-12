package com.example.daybite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GetCardFact("topic")

    }
    fun GetCardFact( interest : String)
    {
        val thread = Thread {
            try {
                val url = URL("https://api.api-ninjas.com/v1/facts?limit=1")
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.setRequestProperty("accept", "application/json")
                connection.addRequestProperty("X-API-Key", "jWJb+UsA874dX+N7U7dpcw==bePxXfEJvhmVjonG")
                val responseStream: InputStream = connection.getInputStream()
                val mapper = ObjectMapper()
                val root: JsonNode = mapper.readTree(responseStream)
                println(root.path("fact").asText())
                //Your code goes here
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        thread.start()

    }
}