package com.example.myfirstapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.item_chat.view.*

/**
 * A simple [Fragment] subclass.
 */

class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val chatList = mutableListOf(
            Chat("Margarete Vogts", "Hey nettes Treffen."),
            Chat("Karen Alscher", "Hey nettes Treffen."),
            Chat("Ulla Graner", "Hey nettes Treffen."),
            Chat("Hilmar Sommer", "Hey nettes Treffen."),
            Chat("Armin Schwartz", "Hey nettes Treffen."),
            Chat("Wiegand Schultheiß", "Hey nettes Treffen."),
            Chat("Gerhard Bauers", "Hey nettes Treffen."),
            Chat("Ekkehard Mayer", "Hey nettes Treffen."),
            Chat("Alwine Falk", "Hey nettes Treffen."),
            Chat("Annelie Walkenhorst", "Hey nettes Treffen."),
            Chat("Kabelo Lauwens", "Hey nettes Treffen."),
            Chat("Keegan Lim", "Hey nettes Treffen."),
            Chat("Sudhir Jakap", "Hey nettes Treffen."),
            Chat("Paderau McConnell", "Hey nettes Treffen."),
            Chat("An Öman", "Hey nettes Treffen."),
        )

        val adapter = ChatAdapter(chatList)
        rvChats.adapter = adapter
        rvChats.layoutManager = LinearLayoutManager(context)

        /*svChat.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                svChat.clearFocus()
                if(chatList.contains(query)) {
                    adapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
*/
    }
}