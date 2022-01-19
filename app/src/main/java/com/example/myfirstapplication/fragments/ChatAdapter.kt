package com.example.myfirstapplication.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatAdapter(
    var chats: List<Chat>
) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>(){

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.itemView.apply {
            tvChatFriend.text = chats[position].profileName
            tvChatPreview.text = chats[position].chatPreview
        }
    }

    override fun getItemCount(): Int {
        return chats.size
    }

}