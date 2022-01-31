package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myfirstapplication.databinding.ActivityMainBinding
import com.example.myfirstapplication.fragments.ActivityFragment
import com.example.myfirstapplication.fragments.ChatFragment
import com.example.myfirstapplication.fragments.FriendsFragment
import com.example.myfirstapplication.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_home_screeen.*

class HomeScreen : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val activityFragment = ActivityFragment()
    private val friendsFragment = FriendsFragment()
    private val chatFragment = ChatFragment()
    //private lateinit var binding: AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screeen)
        replaceFragment(homeFragment)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.icon_home -> replaceFragment(homeFragment)
                R.id.icon_activity -> replaceFragment(activityFragment)
                R.id.icon_friends -> replaceFragment(friendsFragment)
                R.id.icon_chat -> replaceFragment(chatFragment)

              //  R.id.icon_chat -> startActivity(Intent(this, New_Message_Activity::class.java))

            }
            true
        }

        /*idchat.setOnClickListener {
            var intent = Intent(this, New_Message_Activity::class.java)
            startActivity(intent)
        } //Unresolved reference: idchat*/





    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, fragment)
            transaction.commit()
        }
    }
}