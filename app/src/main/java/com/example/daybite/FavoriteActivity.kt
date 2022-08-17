package com.example.daybite

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_favorite_search.*
import kotlinx.android.synthetic.main.fragment_favorite_search.view.*



class FavoriteActivity : AppCompatActivity() {

    lateinit var searchView: SearchView
    lateinit var listView: ListView
    lateinit var adapter: ArrayAdapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_favorite_search)

        val searchClickGo = findViewById<TextView>(R.id.searchClick) // SearchView item
        val searchBarGo = findViewById<TextView>(R.id.searchBar) //Listview item

        fun userFavoriteList(userFavoriteList: ArrayList<String>) {

            searchClick.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {

                    if (userFavoriteList.contains(query))
                    {
                        adapter.filter.filter(query)
                    }
                    else
                    {
                        Toast.makeText(this@FavoriteActivity, "No match found", Toast.LENGTH_LONG).show()
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    TODO("Not yet implemented")
                }
            })
        }

    }









}