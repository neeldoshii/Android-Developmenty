package com.example.basics

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }
    fun btntapped(view: View) {
        var firstVariable : TextView = findViewById(R.id.textView2)

        firstVariable.text = "Hello"
firstVariable.setPadding(500,0,0,0)
        firstVariable.setTextColor(R.color.purple_200)


//        var tryintent=Intent(Intent.ACTION_VIEW)
//        tryintent.setData(Uri.parse("content://contacts/people/+919004757637"))
//        startActivity(tryintent)
//
//
        var id:Int=1;
        val tryintent=Intent(this,SecondActivity::class.java)
        tryintent.putExtra("id",id)
        tryintent.putExtra("name","mmmm")
        startActivity(tryintent)



    }

}