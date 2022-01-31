package com.example.myfirstapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import kotlinx.android.synthetic.main.fragment_activity.*


class ActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var activity1List = mutableListOf(
            Activity1("Wandern"),
            Activity1("Fahrrad fahren"),
            Activity1("Bar besuchen"),
            Activity1("Kino"),

        )

        var activity2List = mutableListOf(

            Activity2("Sport"),
            Activity2("Musik"),
            Activity2("Gaming"),
            Activity2("Natur")
        )

        val adapter1 = Activity1Adapter(activity1List)
        rvActivity1.adapter = adapter1
        rvActivity1.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        val adapter2 = Activity2Adapter(activity2List)
        rvActivity2.adapter = adapter2
        rvActivity2.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)


    }


}