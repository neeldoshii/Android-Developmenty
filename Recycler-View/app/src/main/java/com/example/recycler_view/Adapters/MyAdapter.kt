package com.example.recycler_view.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.recycler_view.List.Songs
import com.example.recycler_view.R
import com.example.recycler_view.R.layout


class MyAdapter(val songs : List<Songs>) : Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =  inflater.inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  songs.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTV.text = songs[position].title
        holder.descriptionTV.text = songs[position].description

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTV = itemView.findViewById<TextView>(R.id.titleTV)
        val descriptionTV = itemView.findViewById<TextView>(R.id.descriptionTV)
    }
}

