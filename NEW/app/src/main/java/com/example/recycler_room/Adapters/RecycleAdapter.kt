package com.example.recycler_room.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.recycler_room.DataBase.EmpData
import com.example.recycler_room.R


//class RecycleAdapter(val list: List<EmpData>, val flist:List<EmpData>,and so on) : Adapter<RecycleAdapter.Vholder>()

class RecycleAdapter(val list: List<EmpData>) : Adapter<RecycleAdapter.Vholder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vholder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.itemcomponent,parent,false)
        return Vholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vholder, position: Int) {
        holder.id.setText(list[position].id.toString())
        holder.fname.setText(list[position].fName)
        holder.lname.setText(list[position].lName)
        holder.Phno.setText(list[position].phoneNo.toString())
    }


    class Vholder(itemco:View):ViewHolder(itemco){

        val id:TextView=itemco.findViewById(R.id.id)
        val Phno:TextView=itemco.findViewById(R.id.Phno)
        val fname:TextView=itemco.findViewById(R.id.fname)
        val lname:TextView=itemco.findViewById(R.id.lname)
    }
}


