package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    lateinit var googleSignInClient: GoogleSignInClient
    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.signInWithGoogle)
        auth = FirebaseAuth.getInstance()
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
                .requestProfile()
                .requestIdToken(getString(R.string.default_web_client_id)).build()

//        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

                result ->
            if (result.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)

                if (task.isSuccessful) {
                    Toast.makeText(this, "Hogya", Toast.LENGTH_SHORT).show()
                    val account: GoogleSignInAccount? = task.result
                    val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)
                    auth.signInWithCredential(credential).addOnCompleteListener() {

                        if (it.isSuccessful) {

                            val currentuser = FirebaseAuth.getInstance().currentUser

                            println("*******************************************")
                            println(credential)
                            println(currentuser?.displayName)
                            println(account.displayName)

                            println(currentuser?.email)
                            println(account.email)
                            println("*******************************************")

                            Toast.makeText(this, "Sucessfull", Toast.LENGTH_SHORT).show()
//                            if (currentuser != null) {
                                intent = Intent(this, MainActivity2::class.java)
                                startActivity(intent)
//                            }
                        } else {
                            Toast.makeText(this, "some error", Toast.LENGTH_SHORT).show()
                        }


                    }
                }
            } else {
                Toast.makeText(this, "pl", Toast.LENGTH_SHORT).show()
            }
        }

            button.setOnClickListener() {
                //Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()

                val signIn = googleSignInClient.signInIntent

//            startActivity(signIn)
                launcher.launch(signIn)

            }


    }
}

