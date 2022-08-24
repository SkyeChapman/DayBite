package com.example.daybite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_favorite_search.*

class FavoriteSearchFunc : AppCompatActivity() {

    lateinit var searchClickGo: SearchView
    lateinit var searchBarGo: ListView
    lateinit var adapter: ArrayAdapter<*>
    lateinit var favoriteList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_favorite_search)

        fun userFavoriteList(userFavoriteList: ArrayList<String>)
        {
            //call FavoriteListActive data file list, make favoriteList equal that
            favoriteList = userFavoriteList

            searchClickGo = findViewById(R.id.searchClick)
            searchBarGo = findViewById(R.id.searchBar)
            adapter = ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, favoriteList) //maybe?
            searchBarGo.adapter = adapter

            searchClick.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {

                    if (userFavoriteList.contains(query))
                    {
                        adapter.filter.filter(query)
                    }
                    else
                    {
                        Toast.makeText(this@FavoriteSearchFunc,"No match found", Toast.LENGTH_LONG).show()
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    adapter.filter.filter(newText)
                    return false
                }
            })

        }

    }



}