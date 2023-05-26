package com.example.viewmodel_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    var count : Int = 0
    lateinit var viewModel:CounterViewModel
    lateinit var counter : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        Always take reference of id after we have written setcontentview(.....)
        //var  counter : TextView = findViewById(R.id.counter)
        counter = findViewById(R.id.counter)
        viewModel= ViewModelProvider(this).get(CounterViewModel::class.java)


        viewModel.count.observe(this, Observer {
            counter.text=it.toString()
        })
    }

    fun btntapped(view: View) {
        viewModel.count.value =++viewModel.num
        println("Dsds")

    }

}

