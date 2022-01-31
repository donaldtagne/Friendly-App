package com.example.myfirstapplication.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import kotlinx.android.synthetic.main.item_activity1.view.*

class Activity1Adapter (
    var activity1: List<Activity1>
    ): RecyclerView.Adapter<Activity1Adapter.Activity1ViewHolder>(){

    inner class Activity1ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Activity1ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity1,parent, false)
        return Activity1ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Activity1ViewHolder, position: Int) {
        holder.itemView.apply {
            tvActivity1.text = activity1[position].name
        }
    }

    override fun getItemCount(): Int {
        return activity1.size
    }

}