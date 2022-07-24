package com.example.daybite.ui
//code by tom
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daybite.R

class BlurbAdapter (private val blurbs:MutableList<Blurb>) :RecyclerView.Adapter<BlurbAdapter.BlurbViewHolder>()
{
    class BlurbViewHolder(blurbView:View) : RecyclerView.ViewHolder(blurbView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlurbViewHolder
    {
        return BlurbViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_feed,parent,false))
    }

    override fun onBindViewHolder(holder: BlurbViewHolder, position: Int)
    {
        val currBlurb = blurbs[position]
        holder.itemView.apply { TODO()}
    }

    override fun getItemCount(): Int
    {
        return blurbs.size
    }
}