package com.appdev.duo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.appdev.duo.R

class HomeFragment() : Fragment() {

    lateinit var lolBtn: ConstraintLayout

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
        lolBtn = view.findViewById(R.id.home_lol_button)
    }

    private fun initListener() {
        lolBtn.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(R.id.lol_home_container, LolMainFragment())
                .addToBackStack(null).commit()
        }
    }
}