package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forget_pass.*
import kotlinx.android.synthetic.main.activity_geschlecht.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sing_up_screen.*

class forget_pass : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pass)
        submit.setOnClickListener{
            val email: String= eduser.text.toString().trim{it<= ' '}
            if(email.isEmpty()){
                Toast.makeText(
                    this@forget_pass,"please enter email adress",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener {task ->
                        if(task.isSuccessful){
                            Toast.makeText(this@forget_pass, "Email sent successfuly to reset your Password", Toast.LENGTH_SHORT).show()
                            finish()
                        }else{
                            Toast.makeText(
                                this@forget_pass,task.exception!!.message.toString(),
                                Toast.LENGTH_SHORT

                            ).show()
                        }
                    }
            }
        }
        eduser.addTextChangedListener(object: TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(eduser.text.toString()).matches()) {
                    submit.isEnabled = true



                }

                else{
                    submit.isEnabled = false
                    eduser.setError("Invalid Email")
                }

            }

        })





    }

}