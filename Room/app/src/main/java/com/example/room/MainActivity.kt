package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"ContactDB").build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(1,"Neel","Doshi",9999999999))

        }


    }
}