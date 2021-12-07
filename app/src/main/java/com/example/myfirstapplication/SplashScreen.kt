package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.logging.Handler

class SplashScreen : AppCompatActivity() {
    private val timeout:Long=3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        android.os.Handler().postDelayed({

            startActivity(Intent(this, MainActivity::class.java)) // loginScreen
            finish()

        }, timeout)






    }
}