package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val userList:ArrayList<User>): RecyclerView.Adapter<RecyclerAdapter.MViewHolder> (){
    //private var friends = arrayOf("A1", "A2", "A3", "A4", "A5")
    //private var  messages= arrayOf("M1", "M2", "M3", "M4", "M5")
  //  private var images = intArrayOf(R.drawable.icon_friends)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {

        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return MViewHolder(itemview)

    }
    override fun getItemCount(): Int {

       return userList.size
    }


    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
         val currentitem = userList[position]
        holder.itemMessage.text= currentitem.stadt
        holder.itemFriend.text=currentitem.username
      //  holder.itemImage.setImageResource(images[position])



    }



      class MViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

       // var itemImage: ImageView
        var itemFriend:TextView = itemView.findViewById(R.id.tvChatFriend)
        var itemMessage:TextView = itemView.findViewById(R.id.tvChatPreview)

    }

}