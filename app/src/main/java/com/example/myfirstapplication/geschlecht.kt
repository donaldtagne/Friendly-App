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
import kotlinx.android.synthetic.main.activity_geschlecht.*
import kotlinx.android.synthetic.main.activity_sing_up_screen.*
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class geschlecht : AppCompatActivity() {
    private lateinit var  tvDatePicker: TextView
    private lateinit var btnDatePicker: CardView
    private lateinit var btnGePicker: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geschlecht)
        weiter.setOnClickListener{
            val intent= Intent(this, Interesse::class.java)
            startActivity(intent)
        }
        tvDatePicker=findViewById(R.id.eddate)
        btnDatePicker= findViewById(R.id.btnDatePicker)
        btnGePicker= findViewById(R.id.eGeschlecht)
        val mycalendar= Calendar.getInstance()
        val datePicker=DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            mycalendar.set(Calendar.YEAR, year)
            mycalendar.set(Calendar.MONTH, month)
            mycalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(mycalendar)
        }

        eGeschlecht.setOnClickListener {
            val builder= AlertDialog.Builder (this@geschlecht)
            val textsArrays= arrayOf(
                "Männlich",
                "Weiblich",
                "Divers"
            )

            val checkedtextsArray = booleanArrayOf(false, false, false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Geschlecht")

            builder.setMultiChoiceItems(textsArrays, checkedtextsArray) {dialog,which, isCHecked->
                checkedtextsArray[which]=isCHecked
                /*val currentItem = textsArrays[which]
                Toast.makeText(applicationContext, currentItem+" "+ isCHecked, Toast.LENGTH_SHORT).show()*/

            }
            builder.setPositiveButton("OK") { dialog, which ->

            }

            val dialog= builder.create()
            dialog.show()

        }

        btnDatePicker.setOnClickListener{
            DatePickerDialog(this,datePicker,mycalendar.get(Calendar.YEAR),mycalendar.get(Calendar.MONTH),
            mycalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
    private fun geschlechtable(){

    }
    private fun updateLable(mycalendar:Calendar){
            val myFormat="dd-MM-yyyy"
        val sdf= SimpleDateFormat(myFormat,Locale.UK)
        tvDatePicker.setText(sdf.format(mycalendar.time))
    }
}
