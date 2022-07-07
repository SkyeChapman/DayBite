package com.example.daybite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        run("http://api.fungenerators.com")
    }

    private fun run(url: String)
    {
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call:Call, e: IOException){}
            override fun onResponse(call: Call, response: Response) = println(response.body?.string())
        })
    }
}