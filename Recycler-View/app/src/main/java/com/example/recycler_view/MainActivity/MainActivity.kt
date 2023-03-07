package com.example.recycler_view.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.Adapters.MyAdapter
import com.example.recycler_view.List.Songs

import com.example.recycler_view.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val songList = findViewById<RecyclerView>(R.id.songList)

        //take the id of Recycler View
        val songsObject = mutableListOf<Songs>()
        songsObject.add(Songs("Title1", "Description1"))
        songsObject.add(Songs("Title2", "Description2"))
        songsObject.add(Songs("Title3", "Description3"))
        songsObject.add(Songs("Title4", "Description4"))
        songsObject.add(Songs("Title5", "Description5"))
        songsObject.add(Songs("Title6", "Description6"))
        songsObject.add(Songs("Title7", "Description7"))
        songsObject.add(Songs("Title8", "Description8"))
        songsObject.add(Songs("Title9", "Description9"))
        songsObject.add(Songs("Title10", "Description10"))
        songList.adapter = MyAdapter(songsObject)
        songList.layoutManager = LinearLayoutManager(this)
    }


}