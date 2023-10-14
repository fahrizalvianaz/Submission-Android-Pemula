package com.example.checktif

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPlaceAdapter(private val listPlace: ArrayList<Place>) : RecyclerView.Adapter<ListPlaceAdapter.ListViewHolder>() {

    var onItemClick : ((Place) -> Unit)?  = null
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.image_place)
        val tvName: TextView = itemView.findViewById(R.id.text_place_name)
        val tvAddress: TextView = itemView.findViewById(R.id.text_place_address)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_place, parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListPlaceAdapter.ListViewHolder, position: Int) {
        val place = listPlace[position]
        holder.imgPhoto.setImageResource(place.placeImages)
        holder.tvName.text = place.placeName
        holder.tvAddress.text = place.placeAddress
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(place)
        }
    }

    override fun getItemCount(): Int = listPlace.size

}