package com.example.myfirstapplication



import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.example.myfirstapplication.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sing_up_screen.*


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.edEmail.addTextChangedListener(object:TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(edEmail.text.toString()).matches()) {
                    binding.Anmelden.isEnabled = true


                }

                else{
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
        binding.pw.setOnClickListener{
            val intent= Intent(this, forget_pass::class.java)
            startActivity(intent)
        }


    }


    private fun submitForm(){
        binding.tvPassword.helperText = validPassword()


        val validPassword = binding.tvPassword.helperText == null

        if(validPassword){

                val intent = Intent(this, HomeScreen::class.java);
                startActivity(intent);

            resetForm()


        }
        else invalidForm()

    }

    private fun invalidForm() {
        var message = ""
        if(binding.tvPassword.helperText != null)
            message += "\n\nPasswort: " + binding.tvPassword.helperText

        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("Okay"){_,_ ->
                //nothing

            }
            .show()
    }

    private fun resetForm() {

        binding.edPassword.text = null


    }

    private fun passwordfocuslistener(){
        binding.edPassword.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus)
            {
                binding.tvPassword.helperText = validPassword()
            }

        }
    }
    private fun validPassword(): String?
    {
        val passwordText = binding.edPassword.text.toString()
        if(passwordText.length < 8)
        {
            return "Minimum acht Character Password"
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

