package com.example.myfirstapplication

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_geschlecht.*
import kotlinx.android.synthetic.main.activity_profilscreen.*
import kotlinx.android.synthetic.main.activity_sing_up_screen.*
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class geschlecht : AppCompatActivity() {
   private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geschlecht)

        tvkonto.setOnClickListener {
            var username= edUser.text.toString()
            val value = if (username.isEmpty())
                deleteData(username)
            else
                Toast.makeText(this ,"please username eingeben", Toast.LENGTH_SHORT).show()

        }

    }
    private fun deleteData(username:String){
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(username).removeValue().addOnSuccessListener {
            Toast.makeText(this, "sucessfully Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "Delete failure", Toast.LENGTH_SHORT).show()
        }


    }
}