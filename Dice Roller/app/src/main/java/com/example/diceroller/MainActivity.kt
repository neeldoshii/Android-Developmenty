package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // created variable rollnobutton to access the xml data, we accessed from R class which stores all values in int
        var rollNoButton: Button = findViewById(R.id.roll_btn)
        var Dice_Number_txtview: TextView = findViewById(R.id.Dice_Number_txtview)
        val diceImageView: ImageView = findViewById(R.id.diceImageView)
        //rollNoButton.text = "Text Changed" //Static Programmatically XML Changed
        var total = 0

        fun random_no(): Unit {
            val randomValues = Random.nextInt(0, 6) + 1 // as dice value start from 1 - 6
            val roll = randomValues
            when (roll) {
//                1 -> Log.d("Test Debug", "Print 1")
//                2 -> Log.d("Test Debug", "Print 2")
//                3 -> Log.d("Test Debug", "Print 3")
//                4 -> Log.d("Test Debug", "Print 4")
//                5 -> Log.d("Test Debug", "Print 5")
//                6 -> Log.d("Test Debug", "Print 6")

                1 -> diceImageView.setImageResource(R.drawable.dice_roll_1)
                2 -> diceImageView.setImageResource(R.drawable.dice_roll_2)
                3 -> diceImageView.setImageResource(R.drawable.dice_roll_3)
                4 -> diceImageView.setImageResource(R.drawable.dice_roll_4)
                5 -> diceImageView.setImageResource(R.drawable.dice_roll_5)
                6 -> diceImageView.setImageResource(R.drawable.dice_roll_6)


            }
            total = total + randomValues
            Dice_Number_txtview.text =
                "Dice Rolled = " + randomValues.toString() + "\nTotal = " + total

            Toast.makeText(this, total.toString(), Toast.LENGTH_SHORT).show()

        }


        rollNoButton.setOnClickListener() {
            random_no()
        }
    }
}




