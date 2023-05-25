package com.example.basics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle : Bundle? = intent.extras
        println(bundle?.get("name"))
        val name:String=(bundle?.get("name") as String)


        val textView:TextView=findViewById(R.id.textView)
        textView.setText(name)
        Log.d("test", bundle?.get("name") as String)


    }
}