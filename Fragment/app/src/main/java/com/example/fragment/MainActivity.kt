package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    val FragmentBtn1:Button=findViewById(R.id.FragmentBtn1)
        var FragmentBtn2:Button=findViewById(R.id.FragmentBtn2)


    FragmentBtn1.setOnClickListener(){
//        val fragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,FirstFragment())
        fragmentTransaction.commit()

    }



        FragmentBtn2.setOnClickListener(){
//        val fragmentManager = supportFragmentManager
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView,SecondFragment())
            fragmentTransaction.commit()

        }












    }


}