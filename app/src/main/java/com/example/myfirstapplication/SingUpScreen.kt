package com.example.myfirstapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myfirstapplication.databinding.ActivitySingUpScreenBinding
import kotlinx.android.synthetic.main.activity_interesse.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sing_up_screen.*
import java.util.*


class SingUpScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySingUpScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idmail.addTextChangedListener(object: TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(idmail.text.toString()).matches()) {
                    button2.isEnabled = true



                }

                else{
                    button2.isEnabled = false
                    idmail.setError("Invalid Email")
                }

            }

        })






        Geschlecht.setOnClickListener {
            val builder=AlertDialog.Builder (this@SingUpScreen)
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