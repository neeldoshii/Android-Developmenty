package com.example.retroapi.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retroapi.R

class NewsListAdapter(val list: List<String>, val imageLink: MutableList<String>):RecyclerView.Adapter<NewsListAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView : TextView = itemView.findViewById(R.id.textView)
        val imageView : ImageView =itemView.findViewById(R.id.imageView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_view_news,parent,false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = list[position]


        Glide.with(holder.imageView).load(imageLink[position]).into(holder.imageView);











        Log.d("size",position.toString())
    }
}