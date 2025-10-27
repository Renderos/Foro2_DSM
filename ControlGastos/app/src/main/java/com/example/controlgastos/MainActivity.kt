package com.example.controlgastos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth
        val currentUser = auth.currentUser

        val welcomeTextView: TextView = findViewById(R.id.welcome_text)

        // Display user's email if they are logged in
        if (currentUser != null) {
            welcomeTextView.text = "Welcome, ${currentUser.email}!"
        } else {
            // This part should ideally not be reached if your login flow is correct
            welcomeTextView.text = "Welcome!"
        }
    }
}
    