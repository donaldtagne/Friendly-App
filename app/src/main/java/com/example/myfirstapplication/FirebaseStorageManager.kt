package com.example.myfirstapplication

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class FirebaseStorageManager {

    private val TAG = "FirebaseStorageManager"
    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    private val mStorageref = FirebaseStorage.getInstance().reference.child("Users")

    fun UploadImage(mContext: Context, imageUri: Uri) {
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Users")
        val currenuser = auth.currentUser
        val currenUserdb = databaseReference?.child(currenuser?.uid!!)
        val uploadTask = currenuser?.let { mStorageref.child(it.uid).putFile(imageUri) }
        if (uploadTask != null) {
            uploadTask.addOnSuccessListener {
                Log.e(TAG, "Image upload successfully")
            }
        }
    }
}