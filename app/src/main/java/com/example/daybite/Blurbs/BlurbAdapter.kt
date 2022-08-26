package com.example.daybite.Blurbs
//code by tom
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.util.SparseBooleanArray
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.daybite.R
import kotlinx.android.synthetic.main.blurb_item.view.*


class BlurbAdapter (private val blurbs:MutableList<Blurb>) :RecyclerView.Adapter<BlurbAdapter.BlurbViewHolder>()
{
    var checkBoxStateArray = SparseBooleanArray()

    inner class BlurbViewHolder(blurbView:View) : RecyclerView.ViewHolder(blurbView){
        fun bind(blurb: Blurb)
        {
            itemView.cbFavoriteButton.isChecked = blurb.mIsFavorited
            itemView.mBlurbBody.text = blurb.mBody
            itemView.mBlurbTitle.text = blurb.mHeader

        }

        var checkBox = itemView.cbFavoriteButton
        init{
            checkBox.setOnClickListener{
                if(!checkBoxStateArray.get(adapterPosition,false))
                {
                    checkBox.isChecked = true
                    checkBoxStateArray.put(adapterPosition, true)
                }
                else
                {
                    checkBox.isChecked = false
                    checkBoxStateArray.put(adapterPosition, false)
                }
            }
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlurbViewHolder
    {
        return BlurbViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.blurb_item,parent,false))
    }

    override fun onBindViewHolder(holder: BlurbViewHolder, position: Int)
    {
        val currBlurb = blurbs[position]
        holder.bind(currBlurb)
        holder.checkBox.isChecked = checkBoxStateArray.get(position,false)
    }

    override fun getItemCount(): Int
    {
        return blurbs.size
    }

    fun GenerateBlurbs()
    {
        for (blurb in 0 until 30)
        {
            val newBlurb = Blurb()
            blurbs.add(newBlurb)
            notifyItemInserted(blurbs.size-1)
        }
    }


    //Kris Changes

    fun getItem(position: Int): Blurb {
        return blurbs[position] as Blurb
    }



    /*fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        var convertView = convertView
        val viewHolder: BlurbViewHolder
        val result: View
        if (convertView == null)
        {
            viewHolder = BlurbViewHolder()
            convertView = LayoutInflater.from(parent.context).inflate(R.layout.blurb_item, parent, false)
            //viewHolder.itemView.mBlurbTitle.text = convertView.findViewById(R.id.mHeader)
            viewHolder.itemView.mBlurbBody.text = convertView.findViewById(R.id.mBlurbBody)
            //viewHolder.itemView.cbFavoriteButton.isChecked = convertView.findViewById(R.id.cbFavoriteButton)
            result = convertView
            convertView.tag = viewHolder
        }
        else
        {
            viewHolder = convertView.tag as BlurbViewHolder
            result = convertView
        }
        val item: Blurb = getItem(position)
        viewHolder.itemView.mBlurbBody.text = item.mBody
        viewHolder.itemView.mBlurbTitle.text = item.mHeader
        viewHolder.itemView.cbFavoriteButton.isChecked = item.mIsFavorited
        return result

    }



    Favorite Checkbox and Message by Kris

    fun FavoriteClick(context: Context)
    {
        //val cbfav = findViewById<CheckBox>(R.id.cbFavoriteButton)
        cbfav.setOnCheckedChangeListener {_, isChecked ->
            if(isChecked)
            {
                context.showToast( "Added to Favorites")
            }
            else
            {
                context.showToast( "Removed from Favorites")
            }
        }
    }*/


    fun Context.showToast(message: CharSequence)
    {
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show()
    }


    /*Favorite Checkbox and Message by Kris

    fun Checked(context: Context)
    {
        val cbfav = findViewById<CheckBox>(R.id.cbFavoriteButton)
        cbfav.setOnCheckedChangeListener {_, isChecked ->
            if(isChecked)
            {
                context.showToast( "Added to Favorites")
            }
            else
            {
                context.showToast( "Removed from Favorites")
            }
        }
    }


    fun Context.showToast(message: CharSequence)
    {
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show()
    }*/



}