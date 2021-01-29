package com.appdev.duo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.appdev.duo.R
import com.google.android.material.tabs.TabLayout

class HomeFragment() : Fragment() {

    lateinit var lolBtn: ConstraintLayout
    lateinit var chatBtn: ConstraintLayout
    lateinit var myInfoBtn: ConstraintLayout
    lateinit var mainViewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initView(view)
        initListener()

        return view
    }
    private fun initView(view: View) {
        lolBtn = view.findViewById(R.id.home_lol)
        chatBtn = view.findViewById(R.id.home_chat)
        myInfoBtn = view.findViewById(R.id.home_myinfo)
        mainViewPager = activity!!.findViewById(R.id.main_viewpager)
    }

    private fun initListener() {
        lolBtn.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(R.id.lol_home_container, LolMainFragment())
                .addToBackStack(null).commit()
        }

        chatBtn.setOnClickListener {
            mainViewPager.currentItem = 1
        }

        myInfoBtn.setOnClickListener {
            mainViewPager.currentItem = 2
        }


    }
}