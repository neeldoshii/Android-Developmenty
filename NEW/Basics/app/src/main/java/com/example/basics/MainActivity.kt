package com.example.basics

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.basics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var databinding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        databinding.textView2.text = "HAHAHA"





    }
    fun btntapped(view: View) {
        var obj = Activity_main_bind("Login Completed")
        var obj2 = Main_activity_2("Click me again")

        databinding.logintxt=obj
databinding.btnvar=obj2


//        var tryintent=Intent(Intent.ACTION_VIEW)
//        tryintent.setData(Uri.parse("content://contacts/people/+919004757637"))
//        startActivity(tryintent)
////
////
//        var id:Int=1;
//        val tryintent=Intent(this,SecondActivity::class.java)
//        tryintent.putExtra("id",id)
//        tryintent.putExtra("name","mmmm")
//        startActivity(tryintent)



    }

}