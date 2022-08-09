package com.example.daybite.Blurbs
//code by tom
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daybite.R
import kotlinx.android.synthetic.main.blurb_item.view.*


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
        holder.itemView.apply {
            mBlurbTitle.text = currBlurb.mHeader
            mBlurbBody.text = currBlurb.mBody
        }
    }

    override fun getItemCount(): Int
    {
        return blurbs.size
    }
    fun GenerateBlurbs()
    {
       for (blurb in 0 until 28)
       {
           val newBlurb = Blurb()
           blurbs.add(newBlurb)
       }
    }
}