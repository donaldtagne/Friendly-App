package com.example.myfirstapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SplashScreen : AppCompatActivity() {
    private val timeout: Long = 3000
    private var user: FirebaseUser? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        user = FirebaseAuth.getInstance().currentUser
        android.os.Handler().postDelayed({
            val intent = if (user == null) Intent(this, MainActivity::class.java)
            else Intent(this, HomeScreen::class.java)
            startActivity(intent) // loginScreen
            finish()
        }, timeout)


    }
}
