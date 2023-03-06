package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    private lateinit var database : ContactDatabase
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"Contact").build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(1,"Neel","Doshi",99999))
            database.contactDao().insertContact(Contact(2,"Neel","Doshi",99999))

        }



    }

    fun getContacts(view: View) {

        database.contactDao().getAllContact().observe(this,{
            Log.d("Tag-Neel", it.toString())
        })
    }
}


