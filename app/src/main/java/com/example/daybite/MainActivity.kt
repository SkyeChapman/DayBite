package com.example.daybite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daybite.Requests.Requests
import com.example.daybite.ui.Card
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val card = Card()
    }
}