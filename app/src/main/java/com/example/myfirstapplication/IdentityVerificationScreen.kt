package com.example.myfirstapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.myfirstapplication.databinding.ActivityIdentityVerificationScreenBinding
import kotlinx.android.synthetic.main.activity_identity_verification_screen.*
import java.io.ByteArrayOutputStream

import java.util.jar.Manifest

class IdentityVerificationScreen : AppCompatActivity() {

    private lateinit var imageUri: Uri
    private lateinit var binding : ActivityIdentityVerificationScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdentityVerificationScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnIdentity.isEnabled = false

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 111)
        }
        else {
            btnIdentity.isEnabled = true
        }

        btnIdentity.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 101)
        }

        btnWeiter.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101) {
            var bitmap = data?.getParcelableExtra<Bitmap>("data")
            //  ivIdentity.setImageBitmap(picture)

            // var bitmap = it.data!!.extras!!.get("data") as Bitmap
            binding.ivIdentity.setImageBitmap(bitmap)
            val bytes = ByteArrayOutputStream()
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100,bytes)
            val path=MediaStore.Images.Media.insertImage(
                this?.contentResolver,bitmap,"val",null
            )
            imageUri = Uri.parse(path)
            FirebaseStorageManager().UploadImage(this, imageUri)
            Toast.makeText(this, "Profilbild hochgeladen!", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this, "Image not clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            btnIdentity.isEnabled = true
        }
    }





}
/*package com.example.myfirstapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_identity_verification_screen.*

import java.util.jar.Manifest

class IdentityVerificationScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identity_verification_screen)

        btnIdentity.isEnabled = false

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 111)
        }
        else {
            btnIdentity.isEnabled = true
        }

        btnIdentity.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 101)
        }

        btnWeiter.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101) {
           var picture = data?.getParcelableExtra<Bitmap>("data")
           ivIdentity.setImageBitmap(picture)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            btnIdentity.isEnabled = true
        }
    }
}*/
