package com.appdev.duo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.appdev.duo.R

class MyInfoListAdapter(val context: Context, val nameList: ArrayList<String>) : BaseAdapter() {
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_myinfo_list, null)
        val nameView = view.findViewById<TextView>(R.id.item_myinfo_title)

        nameView.text = nameList[position]

        return view
    }

    override fun getItem(position: Int): Any {
        return nameList[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return nameList.size
    }

}