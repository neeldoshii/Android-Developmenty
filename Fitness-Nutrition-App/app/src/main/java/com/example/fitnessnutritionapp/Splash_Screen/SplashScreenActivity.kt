package com.example.fitnessnutritionapp.Splash_Screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.fitnessnutritionapp.MainActivity
import com.example.fitnessnutritionapp.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val time :Long = 1000
        Handler().postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            },time)


    }
}