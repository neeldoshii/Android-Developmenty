package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        auth = FirebaseAuth.getInstance()
        var isSingout : Boolean = false
        val btn:Button = findViewById(R.id.button)
        btn.setOnClickListener(){

            FirebaseAuth.getInstance().signOut()
            val currentuser = FirebaseAuth.getInstance().currentUser
            println("***************************")
//            println(currentuser?.email)
//
            if (currentuser == null) {

                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }

        }



    }

}
