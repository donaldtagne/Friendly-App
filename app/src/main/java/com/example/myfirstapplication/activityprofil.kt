package com.example.myfirstapplication

import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myfirstapplication.databinding.ActivityActivityprofilBinding
import com.example.myfirstapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.main.activity_activityprofil.*


class activityprofil : AppCompatActivity() {

    private lateinit var binding: ActivityActivityprofilBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: DatabaseReference
    private lateinit var dialog: Dialog
    private lateinit var user:User
    private lateinit var uid: String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivityprofilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()
        uid= auth.currentUser?.uid.toString()

        databaseReference= FirebaseDatabase.getInstance().getReference("Users")

        if(uid.isNotEmpty()){
            //getUserData()
            loadProfile()
        }

        ibBackProfil.setOnClickListener{
            val intent = Intent(this, Profilscreen::class.java)
            startActivity(intent)
        }
        fabNewPic.setOnClickListener{
            val intent = Intent(this, IdentityVerificationScreen::class.java)
            startActivity(intent)
        }
    }

    companion object{
        private const val TAG = "Activityprofil"
    }

    /*private fun getUserData() {
        Log.d(TAG, "getUserData: getting user data")
        databaseReference.child(uid).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d(TAG, "onDataChange: yes")
                user = snapshot.getValue(User::class.java)!!
                /*binding.tvUserName.setText(user.username)
                binding.tvEmail.setText(user.useremail)
                binding.tvGebursdatum.setText(user.userdatum)
                binding.tvStadtProfil.setText(user.stadt)*/


            }

            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, "onCancelled: error ${error.message}")
            }


        })
    }*/
    private fun loadProfile() {
        val userr = auth.currentUser
        val userrefer = databaseReference?.child(userr?.uid!!)
        userrefer?.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.tvUserName.text = snapshot.child("Username").value.toString()
                binding.tvEmail.text = snapshot.child("Email").value.toString()
                binding.tvGeschlechtProfil.text = snapshot.child("Geschlecht").value.toString()
                binding.tvStadtProfil.text = snapshot.child("Stadt").value.toString()
                binding.tvGebursdatum.text = snapshot.child("Geburtsdatum").value.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}

