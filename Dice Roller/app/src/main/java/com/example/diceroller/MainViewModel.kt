package com.example.diceroller

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.example.diceroller.MainActivity
import androidx.lifecycle.ViewModel
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

//class MainViewModel(private val binding: ActivityMainBinding) : ViewModel() {
//
//    fun random_no(): Unit {
//        val randomValues = Random.nextInt(0, 6) + 1 // as dice value start from 1 - 6
//        val roll = randomValues
//        when (roll) {
//
//            //  Debug
////                1 -> Log.d("Test Debug", "Print 1")
////                2 -> Log.d("Test Debug", "Print 2")
////                3 -> Log.d("Test Debug", "Print 3")
////                4 -> Log.d("Test Debug", "Print 4")
////                5 -> Log.d("Test Debug", "Print 5")
////                6 -> Log.d("Test Debug", "Print 6")
//
//            1 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_1)
//            2 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_2)
//            3 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_3)
//            4 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_4)
//            5 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_5)
//            6 -> binding.diceImageView.setImageResource(R.drawable.dice_roll_6)
//
//
//        }
//        binding.rollBtn.setOnClickListener() {
//            random_no()
//        }
//    }
//
////    binding.rollBtn.setOnClickListener()
////    {
////        random_no()
////    }


class MainViewModel() : ViewModel(), LifecycleOwner {

    lateinit var binding: ActivityMainBinding
    fun onCreate(savedInstanceState: Bundle?) {
        // here we are using DataBindingUtil to access the UI elements from R class
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)

        }




}
