package com.example.myfirstapplication

import android.app.Dialog
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapplication.databinding.ActivityActivityprofilBinding
import com.example.myfirstapplication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


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
            getUserData()
        }




    }

    private fun getUserData() {
        databaseReference.child(uid).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                user = snapshot.getValue(User::class.java)!!
                binding.tvUserName.setText(user.username)
                binding.tvEmail.setText(user.useremail)
                binding.tvGebursdatum.setText(user.userdatum)
                binding.tvStadtProfil.setText(user.stadt)


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")

            }


        })
    }
}

