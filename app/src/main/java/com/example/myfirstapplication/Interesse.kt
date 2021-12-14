package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_interesse.*
import java.util.*

class Interesse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interesse)
        tvsport.setOnClickListener {
            val builder= AlertDialog.Builder (this@Interesse)
            val textsArrays= arrayOf(
                "Football",
                "Schwimmen",
                "Ballett",
                "Basketball",
                "Handball",
                "Tennis",
                "Fitness",
            )

            val checkedtextsArray = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Wählen sie Ihre Interessen")

            builder.setMultiChoiceItems(textsArrays, checkedtextsArray) {dialog,which, isCHecked->
                checkedtextsArray[which]=isCHecked
                /*val currentItem = textsArrays[which]
                Toast.makeText(applicationContext, currentItem+" "+ isCHecked, Toast.LENGTH_SHORT).show()*/

            }
            builder.setPositiveButton("OK"){dialog,which->

            }
            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        tvmusik.setOnClickListener {
            val builder=AlertDialog.Builder (this@Interesse)
            val textsArrays= arrayOf(
                "Hip-Hop",
                "Techno",
                "Pop",
                "Rock",
                "Rap",
                "Schlager",
                "Afro",
            )

            val checkedtextsArray = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Wählen sie Ihre Interessen")

            builder.setMultiChoiceItems(textsArrays, checkedtextsArray) {dialog,which, isCHecked->
                checkedtextsArray[which]=isCHecked
                /*val currentItem = textsArrays[which]
                Toast.makeText(applicationContext, currentItem+" "+ isCHecked, Toast.LENGTH_SHORT).show()*/


            }
            builder.setPositiveButton("OK"){dialog,which->

            }
            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        tvYoga.setOnClickListener {
            val builder=AlertDialog.Builder (this@Interesse)
            val textsArrays= arrayOf(
                "Yin",
                "Ashtanga",
                "Power",
                "Jivamukti",
                "Kundalini",
                "Iyengar",
                "Hatha",
            )

            val checkedtextsArray = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Wählen sie Ihre Interessen")

            builder.setMultiChoiceItems(textsArrays, checkedtextsArray) {dialog,which, isCHecked->
                checkedtextsArray[which]=isCHecked
                /*val currentItem = textsArrays[which]
                Toast.makeText(applicationContext, currentItem+" "+ isCHecked, Toast.LENGTH_SHORT).show()*/


            }
            builder.setPositiveButton("OK"){dialog,which->

            }
            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        tvLuft.setOnClickListener {
            val builder=AlertDialog.Builder (this@Interesse)
            val textsArrays= arrayOf(
                "Segelflug",
                "Motorflug",
                "Ultraleicht",
                "Fallschirm",
                "Drachenfliegen",
                "Ballonflug",
                "Modellflug"
            )

            val checkedtextsArray = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Wählen sie Ihre Interessen")

            builder.setMultiChoiceItems(textsArrays, checkedtextsArray) {dialog,which, isCHecked->
                checkedtextsArray[which]=isCHecked
                /*val currentItem = textsArrays[which]
                 Toast.makeText(applicationContext, currentItem+" "+ isCHecked, Toast.LENGTH_SHORT).show()*/

            }
            builder.setPositiveButton("OK"){dialog,which->

            }
            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        tvLesen.setOnClickListener {
            val builder=AlertDialog.Builder (this@Interesse)
            val textsArrays= arrayOf(
                "Fantasy",
                "Science-Fiction",
                "Liebesromane",
                "Reiseroman",
                "Historischer Roman",
                "Thriller",
                "Drama"
            )

            val checkedtextsArray = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Wählen sie Ihre Interessen")

            builder.setMultiChoiceItems(textsArrays, checkedtextsArray) {dialog,which, isCHecked->
                checkedtextsArray[which]=isCHecked
                /*val currentItem = textsArrays[which]
                 Toast.makeText(applicationContext, currentItem+" "+ isCHecked, Toast.LENGTH_SHORT).show()*/

            }
            builder.setPositiveButton("OK"){dialog,which->

            }
            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        tvfilm.setOnClickListener {
            val builder=AlertDialog.Builder (this@Interesse)
            val textsArrays= arrayOf(
                "Komödie",
                "Horror",
                "Science-Fiction",
                "Abendteuer",
                "Biografische Film",
                "Kriegfilm",
                "zeichentrickfilm"
            )

            val checkedtextsArray = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Wählen sie Ihre Interessen")

            builder.setMultiChoiceItems(textsArrays, checkedtextsArray) {dialog,which, isCHecked->
                checkedtextsArray[which]=isCHecked
                /*val currentItem = textsArrays[which]
                 Toast.makeText(applicationContext, currentItem+" "+ isCHecked, Toast.LENGTH_SHORT).show()*/


            }
            builder.setPositiveButton("OK"){dialog,which->

            }
            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        tvSprachen.setOnClickListener {
            val builder=AlertDialog.Builder (this@Interesse)
            val textsArrays= arrayOf(
                "Englisch",
                "Deutsch",
                "Spanisch",
                "Russich",
                "Türkisch",
                "Französich",
                "Arabisch",
            )

            val checkedtextsArray = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Wählen sie Ihre Interessen")

            builder.setMultiChoiceItems(textsArrays, checkedtextsArray) {dialog,which, isCHecked->
                checkedtextsArray[which]=isCHecked
                /*val currentItem = textsArrays[which]
                Toast.makeText(applicationContext, currentItem+" "+ isCHecked, Toast.LENGTH_SHORT).show()*/

            }
            builder.setPositiveButton("OK"){dialog,which->

            }
            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        tvSpeichern.setOnClickListener {
            val intent = Intent(this, IdentityVerificationScreen::class.java)
            startActivity(intent)
        }

    }
}