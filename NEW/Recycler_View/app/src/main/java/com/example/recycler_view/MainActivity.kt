package com.example.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclersongs:RecyclerView = findViewById(R.id.recyclersongs)
        val slist = listOf<String>("Neel","OK","Siddh","Neel","OK","Siddh","Neel","OK","Siddh","Neel","OK","Siddh")



        recyclersongs.adapter=MyAdapter(slist)
        recyclersongs.layoutManager=LinearLayoutManager(this)

    }
}