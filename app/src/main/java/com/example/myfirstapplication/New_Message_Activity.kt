package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.constraintlayout.helper.widget.Carousel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_new_message.*

class New_Message_Activity : AppCompatActivity() {

   // private var layoutManager: RecyclerView.LayoutManager? = null
   // private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecycleview : RecyclerView
    private lateinit var userArrayList : ArrayList<User>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)

        userRecycleview = findViewById(R.id.recyclerviewvChats)
        userRecycleview.layoutManager = LinearLayoutManager(this)
        userRecycleview.setHasFixedSize(true)

        userArrayList = arrayListOf()
        getUserData()



    }

    private fun getUserData() {
        dbref= FirebaseDatabase.getInstance().getReference("Users")
        dbref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!) // if the userobject is null, an exeption will be called

                    }

                    userRecycleview.adapter = RecyclerAdapter(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}

