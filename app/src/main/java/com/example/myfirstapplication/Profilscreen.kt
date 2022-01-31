package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_privacy.*
import kotlinx.android.synthetic.main.activity_profilscreen.*
import java.util.*

class Profilscreen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

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
        tvbild.setOnClickListener{
            val intent = Intent(this, activityprofil::class.java)
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
    private fun signOut(){
        val user: FirebaseUser?= auth.currentUser
        if (user != null) {
            Toast.makeText(this, "Abgemeldet", Toast.LENGTH_SHORT).show()
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))

        } else  {
            Toast.makeText(this, "Melden Sie sich an!!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))



        }
    }

    private fun kontoloeschen()
    {
        val user: FirebaseUser? = auth.currentUser
        if (user != null){
            user.delete()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Konto geloescht", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, SingUpScreen::class.java))

                    }
                }
        } else {
            Toast.makeText(this, "Melden Sie sich an!!", Toast.LENGTH_SHORT).show()
        }

    }
}

