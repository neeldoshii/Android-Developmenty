package com.example.recycler_room.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.recycler_room.R

class RecycleAdapter(val list: List<String>) : Adapter<RecycleAdapter.Vholder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vholder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.itemcomponent,parent,false)
        return Vholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vholder, position: Int) {
        holder.id.setText(list[position])
        holder.fname.setText(list[position])
        holder.lname.setText(list[position])
        holder.Phno.setText(list[position])
    }


    class Vholder(itemco:View):ViewHolder(itemco){

        val id:TextView=itemco.findViewById(R.id.id)
        val Phno:TextView=itemco.findViewById(R.id.Phno)
        val fname:TextView=itemco.findViewById(R.id.fname)
        val lname:TextView=itemco.findViewById(R.id.lname)
    }
}


