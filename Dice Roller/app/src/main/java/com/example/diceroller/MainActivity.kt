package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // created variable rollnobutton to access the xml data, we accessed from R class which stores all values in int
        var rollNoButton : Button = findViewById(R.id.roll_btn)
        var Dice_Number_txtview : TextView = findViewById(R.id.Dice_Number_txtview)
        //rollNoButton.text = "Text Changed" //Static Programmatically XML Changed
        var total = 0
        
        fun random_no(): Unit {
            val randomValues = Random.nextInt(0, 5) + 1 // as dice value start from 1 - 6
            total = total + randomValues
            Dice_Number_txtview.text = "Dice Rolled = " +randomValues.toString() + "\nTotal = " + total

            Toast.makeText(this,total.toString(), Toast.LENGTH_SHORT).show()

        }


        rollNoButton.setOnClickListener(){
        random_no()
        }
    }
}