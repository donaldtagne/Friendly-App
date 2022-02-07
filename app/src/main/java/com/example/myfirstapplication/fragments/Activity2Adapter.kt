package com.example.myfirstapplication.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import kotlinx.android.synthetic.main.item_activity1.view.*

class Activity2Adapter (
    var activity2: List<Activity2>
    ): RecyclerView.Adapter<Activity2Adapter.Activity2ViewHolder>() {

    inner class Activity2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Activity2ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity1,parent, false)
        return Activity2ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Activity2ViewHolder, position: Int) {
        holder.itemView.apply {
            tvActivity1.text = activity2[position].name
        }
    }

    override fun getItemCount(): Int {
       return activity2.size
    }


}