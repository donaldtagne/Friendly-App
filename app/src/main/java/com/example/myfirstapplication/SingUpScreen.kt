package com.example.myfirstapplication

import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.myfirstapplication.databinding.ActivitySingUpScreenBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.components.Dependency.required
import kotlinx.android.synthetic.main.activity_geschlecht.*
import kotlinx.android.synthetic.main.activity_geschlecht.edgeschlecht
import kotlinx.android.synthetic.main.activity_sing_up_screen.*
import java.text.SimpleDateFormat
import java.util.*


class SingUpScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySingUpScreenBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var anmeldung: Button
    var database : FirebaseDatabase? = null
    var databaseReference: DatabaseReference? = null
    private lateinit var  tvDatePicker: EditText
    private lateinit var btnDatePicker: TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference   = database?.reference!!.child("Users")

        emailFocuslistener()
        passwordFocuslistener()
        passwordWFocuslistener()

        binding.button2.setOnClickListener {
            val username: String = binding.edUser.text.toString()
            val stadt: String = binding.edstadt.text.toString()
            val mail: String = binding.edmail.text.toString()
            val pass: String = binding.edpass.text.toString()
            val passwd: String = binding.edpw.text.toString()
            val geschlecht: String = binding.edgeschlecht.text.toString()
            val geburstsdatum: String = binding.eddatum.text.toString()



            if (username.isNotEmpty() && stadt.isNotEmpty() &&
                mail.isNotEmpty() &&
                pass.isNotEmpty() && passwd.isNotEmpty() && geschlecht.isNotEmpty() && geburstsdatum.isNotEmpty()) {

                registerForm()

                auth.createUserWithEmailAndPassword(
                    binding.edmail.text.toString(),
                    binding.edpass.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {

                            val Username = binding.edUser.text.toString()
                            val stadt = binding.edstadt.text.toString()
                            val email = binding.edmail.text.toString()
                            val pass = binding.edpass.text.toString()
                            val username = Username
                            val currenuser = auth.currentUser
                            val currenUserdb = databaseReference?.child(currenuser?.uid!!)
                            currenUserdb?.child("Username")?.setValue(binding.edUser.text.toString())
                            currenUserdb?.child("Stadt")?.setValue(binding.edstadt.text.toString())
                            currenUserdb?.child("Email")?.setValue(binding.edmail.text.toString())
                            currenUserdb?.child("Geschlecht")?.setValue(binding.edgeschlecht.text.toString())
                            currenUserdb?.child("Geburtsdatum")?.setValue(binding.eddatum.text.toString())

                            binding.edUser.text?.clear()
                            binding.edstadt.text?.clear()
                            binding.edmail.text?.clear()
                            binding.edpass.text?.clear()
                            binding.edgeschlecht.text?.clear()
                            binding.eddatum.text?.clear()

                            Toast.makeText(baseContext, "Successfully Saved",
                                Toast.LENGTH_SHORT).show()
                            var intent =Intent(this, Interesse::class.java)
                            startActivity(intent)
                            finish()
                        }  else {
                            Toast.makeText(this@SingUpScreen,"sign up Failed", Toast.LENGTH_SHORT).show()

                        }
                    }
            } else Toast.makeText(applicationContext, "Alle Felder ausfüllen", Toast.LENGTH_SHORT).show()


        }




           /* edgeschlecht.setOnClickListener {

            val builder= AlertDialog.Builder (this@SingUpScreen)
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

                if (checkedtextsArray == booleanArrayOf(true, false,false)){

                    binding.edgeschlecht.setText("Männlich")
                }
                else if (checkedtextsArray == booleanArrayOf(false, true,false)){

                    binding.edgeschlecht.setText("Weiblich")
                }
                else{
                    binding.edgeschlecht.setText("Divers")
                }

            }
            builder.setPositiveButton("OK"){dialog,which->


            }
            val dialog= builder.create()
            dialog.show()


        } */



        }



    private fun registerForm(){

        binding.tvmail.helperText = emailvalid()
        binding.tvpass.helperText = passwordvalid()
        binding.tvpw.helperText = passwordWvalid()
        val validEmal = binding.tvmail.helperText == null
        val validpass = binding.tvpass.helperText == null
        val validWpass = binding.tvpw.helperText == null

        if(validEmal && validpass && validWpass){
            resertForm()
        }

    }
    private fun resertForm(){

        var message = "Username:" + binding.edUser.text
        message += "\nStadt:" + binding.edstadt.text
        message += "\nEmail:" + binding.edmail.text
        message += "\nPassword:" + binding.edpass.text
        message += "\nPasswordwiderholen:" + binding.edpw.text

        AlertDialog.Builder(this)
            .setTitle("Form submitted")
            .setMessage(message).setPositiveButton("OKAY"){_,_ ->
                binding.edmail.text = null
                binding.edpass.text = null
                binding.edpw.text = null
                binding.tvmail.helperText= getString(R.string.required)
                binding.tvpass.helperText = getString(R.string.required)
                binding.tvpw.helperText = getString(R.string.required)

            }.show()












    }

    private fun emailFocuslistener(){
        binding.edmail.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.tvmail.helperText = emailvalid()
            }
        }
    }
    private fun emailvalid(): String? {
        val emailtext = binding.edmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailtext).matches()){
            return "invalid Email adrress"
        }
        return null
    }

    private fun passwordFocuslistener(){
        binding.edpass.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.tvpass.helperText = passwordvalid()
            }
        }
    }
    private fun passwordvalid(): String? {
        val passwortext = binding.edpass.text.toString()
        if(passwortext.length <8){
            return "Minimum 8 Character Password"
        }
        if(!passwortext.matches(".*[A-Z].*".toRegex())){
            return "Must contain 1 Upper-case Character"
        }
        if(!passwortext.matches(".*[a-z].*".toRegex())){
            return "Must contain 1 lower-case Character"
        }
        if(!passwortext.matches(".*[@#\$+=].*".toRegex())){//
            return "Muss 1 Sonderzeichen haben "
        }
        return null
    }
    private fun passwordWFocuslistener(){
        binding.edpw.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.tvpw.helperText = passwordWvalid()
            }
        }
    }
    private fun passwordWvalid(): String? {
        val passworrtext = binding.edpw.text.toString()
        if(passworrtext.length <8){
            return "Minimu 8 Character Password"
        }
        if(!passworrtext.matches(".*[A-Z].*".toRegex())){
            return "Must contain 1 Upper-case Character"
        }
        if(!passworrtext.matches(".*[a-z]*".toRegex())){

            return "Must contain 1 lower-case Character"
        }
        if(!passworrtext.matches(".*[@#\$+=].*".toRegex())){//
            return "Muss 1 Sonderzeichen haben "
        }
        return null


    }





    }







    /**/













