package com.example.database_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var ContactDatabase1:ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ContactDatabase1 = Room.databaseBuilder(this,ContactDatabase::class.java,"Tempdb").build()

        GlobalScope.launch {
        ContactDatabase1.contactdao().insertdata(Employee(0,"Neel",955555555))
        }
       ContactDatabase1.contactdao().getdataemp().observe(this, Observer { Log.d("Datashit",it.toString()) })    // Live data alreadfy works on background thread so no need to add inside global scope

    }
}