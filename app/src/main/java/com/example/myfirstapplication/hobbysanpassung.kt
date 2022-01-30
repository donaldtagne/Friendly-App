package com.example.myfirstapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_hobbysanpassung.*
import kotlinx.android.synthetic.main.activity_interesse.*
import kotlinx.android.synthetic.main.activity_profilscreen.*
import java.util.*

class hobbysanpassung : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbysanpassung)
        passs.setOnClickListener{
            val intent=Intent(this, Profilscreen::class.java)
            startActivity(intent)
        }
        sport.setOnClickListener {
            val builder= AlertDialog.Builder (this@hobbysanpassung)
            val textsArrays= arrayOf(
                "Football",
                "Schwimmen",
                "Ballett",
                "Basketball",
                "Handball",
                "Tennis",
                "Fitness",
            )

            val arrayChecked = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Hier können sie Ihre Hobbys anpassen")
            builder.setIcon(R.drawable.ic_action_name)
            builder.setMultiChoiceItems(textsArrays, arrayChecked) {dialog,which, isCHecked->
                arrayChecked[which]=isCHecked
                val text = textsArrays[which]
                toast("$text clicked.")

            }
            builder.setPositiveButton("OK"){dialog, which->

                }


            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        movie.setOnClickListener {
            val builder= AlertDialog.Builder (this@hobbysanpassung)
            val textsArrays= arrayOf(
                "Komödie",
                "Horror",
                "Science-Fiction",
                "Abendteuer",
                "Biografische Film",
                "Kriegfilm",
                "zeichentrickfilm"
            )

            val arrayChecked = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Hier können sie Ihre Hobbys anpassen")
            builder.setIcon(R.drawable.ic_action_name)
            builder.setMultiChoiceItems(textsArrays, arrayChecked) {dialog,which, isCHecked->
                arrayChecked[which]=isCHecked
                val text = textsArrays[which]
                toast("$text clicked.")

            }
            builder.setPositiveButton("OK"){dialog, which->

            }


            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }

        sprache.setOnClickListener {
            val builder= AlertDialog.Builder (this@hobbysanpassung)
            val textsArrays= arrayOf(
                "Englisch",
                "Deutsch",
                "Spanisch",
                "Russich",
                "Türkisch",
                "Französich",
                "Arabisch",
            )

            val arrayChecked = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Hier können sie Ihre Hobbys anpassen")
            builder.setIcon(R.drawable.ic_action_name)
            builder.setMultiChoiceItems(textsArrays, arrayChecked) {dialog,which, isCHecked->
                arrayChecked[which]=isCHecked
                val text = textsArrays[which]
                toast("$text clicked.")

            }
            builder.setPositiveButton("OK"){dialog, which->

            }


            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        lesen.setOnClickListener {
            val builder= AlertDialog.Builder (this@hobbysanpassung)
            val textsArrays= arrayOf(
                "Fantasy",
                "Science-Fiction",
                "Liebesromane",
                "Reiseroman",
                "Historischer Roman",
                "Thriller",
                "Drama"
            )

            val arrayChecked = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Hier können sie Ihre Hobbys anpassen")
            builder.setIcon(R.drawable.ic_action_name)
            builder.setMultiChoiceItems(textsArrays, arrayChecked) {dialog,which, isCHecked->
                arrayChecked[which]=isCHecked
                val text = textsArrays[which]
                toast("$text clicked.")

            }
            builder.setPositiveButton("OK"){dialog, which->

            }


            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        luft.setOnClickListener {
            val builder= AlertDialog.Builder (this@hobbysanpassung)
            val textsArrays= arrayOf(
                "Segelflug",
                "Motorflug",
                "Ultraleicht",
                "Fallschirm",
                "Drachenfliegen",
                "Ballonflug",
                "Modellflug"
            )

            val arrayChecked = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Hier können sie Ihre Hobbys anpassen")
            builder.setIcon(R.drawable.ic_action_name)
            builder.setMultiChoiceItems(textsArrays, arrayChecked) {dialog,which, isCHecked->
                arrayChecked[which]=isCHecked
                val text = textsArrays[which]
                toast("$text clicked.")

            }
            builder.setPositiveButton("OK"){dialog, which->

            }


            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }


        yoga.setOnClickListener {
            val builder= AlertDialog.Builder (this@hobbysanpassung)
            val textsArrays= arrayOf(
                "Yin",
                "Ashtanga",
                "Power",
                "Jivamukti",
                "Kundalini",
                "Iyengar",
                "Hatha",
            )

            val arrayChecked = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Hier können sie Ihre Hobbys anpassen")
            builder.setIcon(R.drawable.ic_action_name)
            builder.setMultiChoiceItems(textsArrays, arrayChecked) {dialog,which, isCHecked->
                arrayChecked[which]=isCHecked
                val text = textsArrays[which]
                toast("$text clicked.")

            }
            builder.setPositiveButton("OK"){dialog, which->

            }


            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }

        kochen.setOnClickListener {
            val builder= AlertDialog.Builder (this@hobbysanpassung)
            val textsArrays= arrayOf(
                "Vegane",
                "Fleisch",
                "vegetarisch",
                "Backen",
                "Grillen",
            )

            val arrayChecked = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Hier können sie Ihre Hobbys anpassen")
            builder.setIcon(R.drawable.ic_action_name)
            builder.setMultiChoiceItems(textsArrays, arrayChecked) {dialog,which, isCHecked->
                arrayChecked[which]=isCHecked
                val text = textsArrays[which]
                toast("$text clicked.")

            }
            builder.setPositiveButton("OK"){dialog, which->

            }


            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }
        musik.setOnClickListener {
            val builder= AlertDialog.Builder (this@hobbysanpassung)
            val textsArrays= arrayOf(
                "Hip-Hop",
                "Techno",
                "Pop",
                "Rock",
                "Rap",
                "Schlager",
                "Afro",
            )

            val arrayChecked = booleanArrayOf(false, false,false, false, false,false,false)

            val textsList = Arrays.asList(*textsArrays)
            builder.setTitle("Hier können sie Ihre Hobbys anpassen")
            builder.setIcon(R.drawable.ic_action_name)
            builder.setMultiChoiceItems(textsArrays, arrayChecked) {dialog,which, isCHecked->
                arrayChecked[which]=isCHecked
                val text = textsArrays[which]
                toast("$text clicked.")

            }
            builder.setPositiveButton("OK"){dialog, which->

            }


            builder.setNeutralButton("Cancel"){dialog,which->
                dialog.dismiss()
            }
            val dialog= builder.create()
            dialog.show()
        }


    }
    fun Context.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}





