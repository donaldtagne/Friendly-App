package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_geschlecht.*
import kotlinx.android.synthetic.main.activity_sing_up_screen.*
import java.util.*

class geschlecht : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geschlecht)
        weiter.setOnClickListener{
            val intent= Intent(this, Interesse::class.java)
            startActivity(intent)
        }
        eGeschlecht.setOnClickListener {
            val builder= AlertDialog.Builder (this@geschlecht)
            val textsArrays= arrayOf(
                "Männlich",
                "Weiblich",
            )

            val checkedtextsArray = booleanArrayOf(false, false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Geschlecht")

            builder.setMultiChoiceItems(textsArrays, checkedtextsArray) {dialog,which, isCHecked->
                checkedtextsArray[which]=isCHecked
                val currentItem = textsArrays[which]
                Toast.makeText(applicationContext, currentItem+" "+ isCHecked, Toast.LENGTH_SHORT).show()

            }
            builder.setPositiveButton("OK"){dialog,which->

            }
            val dialog= builder.create()
            dialog.show()
        }
    }
}