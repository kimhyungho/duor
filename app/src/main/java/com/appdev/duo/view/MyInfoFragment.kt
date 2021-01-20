package com.appdev.duo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.appdev.duo.R
import kotlinx.android.synthetic.main.fragment_my_info.*
import org.w3c.dom.Text

class MyInfoFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_info, container, false)

//        val click = view.findViewById<ConstraintLayout>(R.id.myinfo_alarm)
//        click.setOnClickListener {
//            fragmentManager!!.beginTransaction().replace(R.id.myinfo_container, InquireFragment())
//                .addToBackStack(null).commit()
//        }

        return view
    }
}