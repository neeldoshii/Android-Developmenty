package com.example.recycler_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recycler_room.Adapters.RecycleAdapter
import com.example.recycler_room.DataBase.EmpData
import com.example.recycler_room.DataBase.EmpDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var i:Int=0

    lateinit var dataBase:EmpDatabase;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val RecyclerView=findViewById<RecyclerView>(R.id.Recycleparent)
//        val Listdata= listOf<String>("1","2")
//        val fList= listOf<String>("ssds","wewe")
//        val lList= listOf<String>("ew","2ewe")
//        val PhnList= listOf<String>("ew1","2ewew")
//        val etFirstName:EditText = findViewById(R.id.etFirstName)
//        val etLastName:EditText = findViewById(R.id.etLastName)
//        val etPhoneNO:EditText = findViewById(R.id.etPhoneNO)
        dataBase = Room.databaseBuilder(this, EmpDatabase::class.java, "emp").build()


//        GlobalScope.launch {
//
//            dataBase.empDataAccess().insertData(EmpData(0, etFirstName.toString(),etLastName.toString() ,(etPhoneNO.toString()).toInt()))
//
//        }
    // Live data alreadfy works on background thread so no need to add inside global scope

        val a = dataBase.empDataAccess().getAll().observe(this, Observer {
                it -> RecyclerView.adapter = RecycleAdapter(it)

        })




        //RecyclerView.adapter = RecycleAdapter(Listdata,flist,lList,PhnList)
        RecyclerView.layoutManager=LinearLayoutManager(this)
    }


    @OptIn(DelicateCoroutinesApi::class)
    fun btnTapped(view: View) {

        val etFirstName:EditText = findViewById(R.id.etFirstName)
        val etLastName:EditText = findViewById(R.id.etLastName)
        val etPhoneNO:EditText = findViewById(R.id.etPhoneNO)
//
        GlobalScope.launch {

            dataBase.empDataAccess().insertData(EmpData(0, etFirstName.getText().toString(),etLastName.getText().toString(),etPhoneNO.getText().toString()))

        }
    }


}