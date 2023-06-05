package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        auth = FirebaseAuth.getInstance()

        val btn:Button = findViewById(R.id.button)
        btn.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            val currentuser = FirebaseAuth.getInstance().currentUser


            if (currentuser == null) {
                println("Not login")
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }

        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
                .requestProfile()
                .requestIdToken(getString(R.string.default_web_client_id)).build()



    }

}
