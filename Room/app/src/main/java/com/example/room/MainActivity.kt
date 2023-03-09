package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.room.Adapter.RecyclerAdapter
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    private lateinit var database: ContactDatabase


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvlayout = findViewById<RecyclerView>(R.id.rvlayout)
        database =
            Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "Contact").build()

        GlobalScope.launch {

            database.contactDao().insertContact(Contact(1, "Neel", "Doshi", 9999999999))
            database.contactDao().insertContact(Contact(2, "Sid", "Jondhale", 8888888888))
            database.contactDao().insertContact(Contact(3, "Aryaman", "Mishra", 7777777777))

        }

        val contacts = database.contactDao().getAllContact().observe(this) { contacts ->
            rvlayout.adapter = RecyclerAdapter(contacts)
        }
        rvlayout.layoutManager = LinearLayoutManager(this)



    }




}


