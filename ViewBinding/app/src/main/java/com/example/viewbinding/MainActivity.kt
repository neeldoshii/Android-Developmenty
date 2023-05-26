package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count : Int = 0
    lateinit var viewModel:Counter_Viewmodel
    var  counter : TextView = findViewById(R.id.counter)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel=ViewModelProvider(this).get(Counter_Viewmodel::class.java)


        viewModel.count.observe(this, Observer {
            counter.text=it.toString()
        })

    }





//    fun btntapped(view: View) {
//     //viewModel.count.value =viewModel.num
//println("Dsds")
//
//    }

}