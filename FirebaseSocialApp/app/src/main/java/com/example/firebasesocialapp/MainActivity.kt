package com.example.firebasesocialapp

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    //    private val REQ_ONE_TAP = 2  // Can be any integer unique to the Activity
//    private var showOneTapUI = true
//    lateinit var signInRequest: BeginSignInRequest
//    private lateinit var auth: FirebaseAuth
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        auth = Firebase.auth
//        signInRequest = BeginSignInRequest.builder()
//            .setGoogleIdTokenRequestOptions(
//                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
//                    .setSupported(true)
//                    // Your server's client ID, not your Android client ID.
//                    .setServerClientId(getString(R.string.default_web_client_id))
//                    // Only show accounts previously used to sign in.
//                    .setFilterByAuthorizedAccounts(true)
//                    .build()
//            )
//            .build()
//
//
//        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//            super.onActivityResult(requestCode, resultCode, data)
//
//            when (requestCode) {
//                REQ_ONE_TAP -> {
//                    try {
//                        val credential = oneTapClient.getSignInCredentialFromIntent(data)
//                        val idToken = credential.googleIdToken
//                        when {
//                            idToken != null -> {
//                                // Got an ID token from Google. Use it to authenticate
//                                // with Firebase.
//                                Log.d(TAG, "Got ID token.")
//                            }
//                            else -> {
//                                // Shouldn't happen.
//                                Log.d(TAG, "No ID token!")
//                            }
//                        }
//                    } catch (e: ApiException) {
//                        // ...
//
//
//                    }
//                }
//            }
//            }
//    }
//}

            auth = FirebaseAuth.getInstance()

            auth = FirebaseAuth.getInstance()

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(this , gso)

            findViewById<Button>(R.id.button).setOnClickListener {
                signInGoogle()
            }
        }
        private fun signInGoogle(){
            val signInIntent = googleSignInClient.signInIntent
            launcher.launch(signInIntent)
        }

        private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->
            if (result.resultCode == Activity.RESULT_OK){

                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleResults(task)
            }
        }

        private fun handleResults(task: Task<GoogleSignInAccount>) {
            if (task.isSuccessful){
                val account : GoogleSignInAccount? = task.result
                if (account != null){
                    updateUI(account)
                }
            }else{
                Toast.makeText(this, task.exception.toString() , Toast.LENGTH_SHORT).show()
            }
        }

        private fun updateUI(account: GoogleSignInAccount) {
            val credential = GoogleAuthProvider.getCredential(account.idToken , null)
            auth.signInWithCredential(credential).addOnCompleteListener {
                if (it.isSuccessful){
                    /*val intent : Intent = Intent(this , HomeActivity::class.java)
                    intent.putExtra("email" , account.email)
                    intent.putExtra("name" , account.displayName)
                    startActivity(intent)*/
                    Log.d("MySuccess", "${account.displayName}")
                    Toast.makeText(this, "${account.displayName}" , Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()

                }
            }
        }
    }