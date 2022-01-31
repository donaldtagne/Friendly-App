package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myfirstapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.edEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(edEmail.text.toString())
                        .matches()
                ) {
                    binding.Anmelden.isEnabled = true


                } else {
                    binding.Anmelden.isEnabled = false
                    binding.edEmail.setError("Invalid Email")
                }

            }

        })

        passwordfocuslistener()
        binding.Anmelden.setOnClickListener { submitForm() }

        binding.Registrieren.setOnClickListener {
            val intent = Intent(this, SingUpScreen::class.java);
            startActivity(intent);
        }
        binding.pw.setOnClickListener {
            val intent = Intent(this, forget_pass::class.java)
            startActivity(intent)
        }


    }


    private fun submitForm() {
        binding.tvPassword.helperText = validPassword()
        val validPassword = binding.edPassword.text != null
        val validEmail = binding.edEmail.text != null
        if (validPassword && validEmail) {
            signIn(binding.edEmail.text.toString(), binding.edPassword.text.toString())
        } else invalidForm()

    }

    companion object {
        private const val TAG = "MainActivity"
    }

    private fun signIn(email: String, password: String) {
        val auth = FirebaseAuth.getInstance();
        Log.d(TAG, "signIn: email and password $email , $password")
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    val intent = Intent(this, HomeScreen::class.java);
                    startActivity(intent);
                    resetForm()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    resetForm()
                }
            }
    }

    private fun invalidForm() {
        var message = ""
        if (binding.tvPassword.helperText != null)
            message += "\n\nPasswort: " + binding.tvPassword.helperText

        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("Okay") {_,_ ->
                //nothing

            }
            .show()
    }

    private fun resetForm() {

        binding.edPassword.text = null


    }

    private fun passwordfocuslistener() {
        binding.edPassword.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.tvPassword.helperText = validPassword()
            }

        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.edPassword.text.toString()
        if (passwordText.length < 8) {
            return "Minimum acht Character Password"
        }

        if (!passwordText.matches(".*[A-Z].*".toRegex())) {//
            return "Muss 1 Großbuchstabe haben "
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {//
            return "Muss 1 Kleinbuchstabe haben "
        }
        if (!passwordText.matches(".*[@#\$+=].*".toRegex())) {//
            return "Muss 1 Sonderzeichen haben "
        }
        return null

    }

}