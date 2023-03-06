package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        }



    }
}


//GetBudgetTuned .com
//thefinancebanking.com
//fortunedollar.com

//fortunedollarblog.com

//getfinancewise.com