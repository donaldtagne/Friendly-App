package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_privacy.*
import java.text.SimpleDateFormat
import java.util.*



class Privacy : AppCompatActivity() {
    private lateinit var online: TextView
    private lateinit var onlin: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)
            var selectedItemIndex = 0
            tvonline.setOnClickListener {
                val onlinearray = arrayOf(
                    "None",
                    "Niemand",
                    "Freunde",
                    "Jeder",
                    )
                var selectedRingtone = onlinearray[selectedItemIndex]
                MaterialAlertDialogBuilder(this)
                    .setTitle("Wähle eine Option")
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
        tvprofil.setOnClickListener {
            val onlinearray = arrayOf(
                "None",
                "Niemand",
                "Freunde",
                "Jeder",
            )
            var selectedRingtone = onlinearray[selectedItemIndex]
            MaterialAlertDialogBuilder(this)
                .setTitle("Wähle eine Option")
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
        tvinfo.setOnClickListener {
            val onlinearray = arrayOf(
                "None",
                "Niemand",
                "Freunde",
                "Jeder",
            )
            var selectedRingtone = onlinearray[selectedItemIndex]
            MaterialAlertDialogBuilder(this)
                .setTitle("Wähle eine Option")
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
        tvblockiert.setOnClickListener {
            val onlinearray = arrayOf(
                "None",
                "Niemand",
                "Freunde",
                "Jeder",
            )
            var selectedRingtone = onlinearray[selectedItemIndex]
            MaterialAlertDialogBuilder(this)
                .setTitle("Wähle eine Option")
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
        tvort.setOnClickListener {
            val onlinearray = arrayOf(
                "None",
                "Niemand",
                "Freunde",
                "Jeder",
            )
            var selectedRingtone = onlinearray[selectedItemIndex]
            MaterialAlertDialogBuilder(this)
                .setTitle("Wähle eine Option")
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
        tvsave.setOnClickListener {
            val intent=Intent(this, Profilscreen::class.java)
            startActivity(intent)
        }


        }
    private fun showSnackbar(msg: String) {
        Snackbar.make(tvonline, msg, Snackbar.LENGTH_LONG).show()
    }
}

