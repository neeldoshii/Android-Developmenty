package com.example.diceroller

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.diceroller.databinding.ActivityMainBinding

import kotlin.random.Random

open class MainActivity : AppCompatActivity() {

    //binding
    private lateinit var binding: ActivityMainBinding
    // viewModel
    private  lateinit var MainViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // here we are using DataBindingUtil to access the UI elements from R class
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // dataBindingObj is a obj  of dataclass DataBinding
        val dataBindingObj = DataBinding("Roll your Dice")

        //Now here we made binding . variable name in data of xml =  dataBindingObj
        binding.data = dataBindingObj

        // Making View Model because here when we rotate the lifecycle oncreate is called so our valled get 0

        MainViewModel = ViewModelProvider(this).get(MainViewModel ::class.java)




//        var total = 0
//
//        fun random_no(): Unit {
//            val randomValues = Random.nextInt(0, 6) + 1 // as dice value start from 1 - 6
//            val roll = randomValues
//            when (roll) {
//
//                //  Debug
////                1 -> Log.d("Test Debug", "Print 1")
////                2 -> Log.d("Test Debug", "Print 2")
////                3 -> Log.d("Test Debug", "Print 3")
////                4 -> Log.d("Test Debug", "Print 4")
////                5 -> Log.d("Test Debug", "Print 5")
////                6 -> Log.d("Test Debug", "Print 6")
//
//                1 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_1)
//                2 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_2)
//                3 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_3)
//                4 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_4)
//                5 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_5)
//                6 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_6)
//
//
//            }
//            total = total + randomValues
////            Dice_Number_txtview.text =
////                "Dice Rolled = " + randomValues.toString() + "\nTotal = " + total
//
//            Toast.makeText(
//                this,
//                "Dice Rolled = " + roll + "\n Total since roll =" + total.toString(),
//                Toast.LENGTH_SHORT
//            ).show()
//
//        }
//
//
//        binding.rollBtn.setOnClickListener() {
//            random_no()
//        }
    }
}




