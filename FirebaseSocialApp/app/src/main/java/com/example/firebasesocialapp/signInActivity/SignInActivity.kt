package com.example.firebasesocialapp.signInActivity

import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.firebasesocialapp.R
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {
    lateinit var oneTapClient: SignInClient
    lateinit var signInRequest: BeginSignInRequest
    private val REQ_ONE_TAP = 2  // Can be any integer unique to the Activity
    private var showOneTapUI = true
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        mAuth = Firebase.auth
        var btnLoginWithGoogle:Button = findViewById(R.id.btnLoginWithGoogle)



//        BeginSignInRequest.builder()
//            .setGoogleIdTokenRequestOptions(
//                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
//                    .setSupported(true)
//                    // Your server's client ID, not your Android client ID.
//                    .setServerClientId(getString(R.string.client_id))
//                    // Only show accounts previously used to sign in.
//                    .setFilterByAuthorizedAccounts(true)
//                    .build()
//            )
//            .build()

        fun updateUI(currentUser: Any) {
            Toast.makeText(this, mAuth.currentUser?.phoneNumber.toString(), Toast.LENGTH_SHORT).show()
        }

        fun onStart() {
            super.onStart()
            // Check if user is signed in (non-null) and update UI accordingly.
            var currentUser = mAuth.getCurrentUser()

                //updateUI(currentUser!!)

        }


        oneTapClient = Identity.getSignInClient(this)
        signInRequest = BeginSignInRequest.builder()
            .setPasswordRequestOptions(
                BeginSignInRequest.PasswordRequestOptions.builder()
                    .setSupported(true)
                    .build()
            )
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(getString(R.string.default_web_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
             //Automatically sign in when exactly one credential is retrieved.
            .setAutoSelectEnabled(true)
            .build()

        btnLoginWithGoogle.setOnClickListener {
            oneTapClient.beginSignIn(signInRequest).addOnSuccessListener { result ->
                try {

                    startIntentSenderForResult(
                        result.pendingIntent.intentSender, REQ_ONE_TAP,
                        null, 0, 0, 0, null
                    )
                } catch (e: IntentSender.SendIntentException) {
                    Log.e("Error", "Couldn't start One Tap UI: ${e.localizedMessage}")
                }
            }.addOnFailureListener {
                Log.d("Error", it.localizedMessage)
            }
        }




        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            when (requestCode) {
                REQ_ONE_TAP -> {
                    try {
                        val credential = oneTapClient.getSignInCredentialFromIntent(data)
                        val idToken = credential.googleIdToken
                        val username = credential.id
                        val password = credential.password
                        println("**************************")
                        println(idToken)
                        println(username)
                        println(password)
                        println("**************************")

                        when {
                            idToken != null -> {
                                // Got an ID token from Google. Use it to authenticate
                                // with your backend.
                                Log.d("Debug", "Got ID token.")
                            }
                            password != null -> {
                                // Got a saved username and password. Use them to authenticate
                                // with your backend.
                                mAuth.signInWithEmailAndPassword(username, password)
                                    .addOnSuccessListener {
                                        Toast.makeText(this, it.user?.email, Toast.LENGTH_SHORT)
                                            .show()
                                    }.addOnFailureListener {
                                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT)
                                            .show()

                                    }
                                Log.d("Debug", "Got password.")

                            }
                            else -> {
                                // Shouldn't happen.
                                Log.d("Error", "No ID token or password!")
                            }
                        }
                    } catch (e: ApiException) {
                        // ...
                        println("hmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")
                    }
                }
            }
        }


































    }
//    override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        var currentUser = mAuth.getCurrentUser()
//        Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
//        //updateUI(currentUser);
//    }

}

