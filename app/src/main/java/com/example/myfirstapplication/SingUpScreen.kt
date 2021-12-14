package com.example.myfirstapplication

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myfirstapplication.databinding.ActivitySingUpScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_interesse.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sing_up_screen.*
import java.util.*


class SingUpScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySingUpScreenBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        edmail.addTextChangedListener(object: TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(edmail.text.toString()).matches()) {
                    button2.isEnabled = true



                }

                else{
                    button2.isEnabled = false
                    edmail.setError("Invalid Emaill")
                }

            }

        })




        passwordfocuslistener()
        binding.button2.setOnClickListener {

            auth.createUserWithEmailAndPassword( edmail.text.toString(), edpass.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        Toast.makeText(baseContext, "Authentication succes.",
                            Toast.LENGTH_SHORT).show()
                        // val user = auth.currentUser
                        // updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        //  updateUI(null)
                    }

                }
            submitForm()




        }
    }




    private fun submitForm(){
        binding.tvpass.helperText = validPassword()


        val validPassword = binding.tvpass.helperText == null

        if(validPassword){

            val intent = Intent(this, geschlecht::class.java);
            startActivity(intent);

            resetForm()


        }
        else invalidForm()

    }

    private fun invalidForm() {
        var message = ""
        if(binding.tvpass.helperText != null)
            message += "\n\nPasswort: " + binding.tvpass.helperText

        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("Okay"){_,_ ->
                //nothing

            }
            .show()
    }

    private fun resetForm() {

        binding.edpass.text = null


    }

    private fun passwordfocuslistener(){
        binding.edpass.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus)
            {
                binding.tvpass.helperText = validPassword()
            }

        }
    }
    private fun validPassword(): String?
    {
        val passwordText = binding.edpass.text.toString()
        if(passwordText.length < 8)
        {
            return "Minimum 8 Character Password"
        }

        if(!passwordText.matches(".*[A-Z].*".toRegex())){//
            return "Muss 1 Großbuchstabe haben "
        }
        if(!passwordText.matches(".*[a-z].*".toRegex())){//
            return "Muss 1 Kleinbuchstabe haben "
        }
        if(!passwordText.matches(".*[@#\$+=].*".toRegex())){//
            return "Muss 1 Sonderzeichen haben "
        }
        return null
    }











}