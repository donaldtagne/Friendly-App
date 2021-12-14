package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forget_pass.*
import kotlinx.android.synthetic.main.activity_geschlecht.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sing_up_screen.*

class forget_pass : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pass)
        submit.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }






    }
}