package com.example.daybite.Favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daybite.Blurbs.Blurb
import com.example.daybite.Blurbs.BlurbAdapter
import com.example.daybite.R
import kotlinx.android.synthetic.main.blurb_item.view.*

class FavoritesAdapter (private val favBlurbs:MutableList<Blurb>) : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {
    class FavoritesViewHolder(blurbView: View) : RecyclerView.ViewHolder(blurbView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.blurb_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val currBlurb = favBlurbs[position]
        holder.itemView.apply {
            mBlurbTitle.text = currBlurb.mHeader
            mBlurbBody.text = currBlurb.mBody
        }
    }

    override fun getItemCount(): Int {
        return favBlurbs.size
    }
}