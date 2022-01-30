package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_privacy.*
import kotlinx.android.synthetic.main.activity_profilscreen.*
import java.util.*

class Profilscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profilscreen)

        Goback.setOnClickListener {
            val intent= Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }
        tvprivacy.setOnClickListener {
            val intent = Intent(this, Privacy::class.java)
            startActivity(intent)
        }
        tvabmelden.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        tvhobby.setOnClickListener {
            val intent= Intent(this,  hobbysanpassung::class.java)
            startActivity(intent)
        }
        var selectedItemIndex = 0
        tvkonto.setOnClickListener {

            val onlinearray = arrayOf(
                "ich habe gefunden, was ich suchte.",
                "Die Leute sind unfreundlich.",
                "Die App gefällt mir nicht.",
                "Ich  bin nur neugierig.",
                )
            var selectedRingtone = onlinearray[selectedItemIndex]

            MaterialAlertDialogBuilder(this)
                .setTitle("Warum löschen sie Ihr Account")
                .setIcon(R.drawable.ic_action_name)
                .setSingleChoiceItems(onlinearray, selectedItemIndex) { dialog, which ->
                    selectedItemIndex = which
                    selectedRingtone = onlinearray[which]
                }
                .setPositiveButton("Ok") { dialog, which ->
                    //showSnackbar("$selectedRingtone Selected")
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }
                .show()
        }
    }
}

