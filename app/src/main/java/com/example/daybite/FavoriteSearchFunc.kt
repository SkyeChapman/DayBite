package com.example.daybite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_favorite_search.*
import kotlinx.android.synthetic.main.fragment_reg_interest.*

class FavoriteSearchFunc : AppCompatActivity() {

    //vars for search function
    lateinit var searchClickGo: SearchView
    lateinit var searchBarGo: ListView
    lateinit var adapter: ArrayAdapter<*>
    lateinit var favoriteList: ArrayList<String>

    //vars for filter function
    lateinit var selectedFilter: String
    lateinit var favoriteFilter: ArrayList<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_favorite_search)


        //FAVORITE SEARCH FUNCTION
        fun userFavoriteListSearch(userFavoriteList: ArrayList<String>)
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

        //FAVORITE FILTER BY INTEREST FUNCTION


        val miscButton = findViewById<Button>(R.id.MiscellaneousFav)
        val assortButton = findViewById<Button>(R.id.AssortedFav)
        val randomButton = findViewById<Button>(R.id.RandomFav)
        val unsortedButton = findViewById<Button>(R.id.UnsortedFav)
        val variedButton = findViewById<Button>(R.id.VariedFav)
        val disorderedButton = findViewById<Button>(R.id.DisorderedFav)
        val conglomerateButton = findViewById<Button>(R.id.ConglomerateFav)

        //checking if button is pressed
        //checking if favorite list contains string of interest
        //filter by string with array adapter
        fun filterFavorite(favoriteFilter: FavoriteListActive)
        {
            if (miscButton.isPressed)
            {

               if (favoriteList.contains("Miscellaneous"))
               {
                   with(adapter) { filter.filter("Miscellaneous") }
               }
            }
            else if (assortButton.isPressed)
            {
                if (favoriteList.contains("Assorted"))
                {
                    with(adapter) { filter.filter("Assorted")}
                }
            }
            else if (randomButton.isPressed)
            {
                if (favoriteList.contains("Random"))
                {
                    with(adapter) { filter.filter("Assorted")}
                }
            }
        }






    }



}