package com.appdev.duo.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appdev.duo.R
import com.appdev.duo.adapter.LolPostAdapter
import com.appdev.duo.data.LolPost
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class LolMainFragment() : Fragment() {
    lateinit var filterBtn: ConstraintLayout
    lateinit var writeBtn: FloatingActionButton
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lol_main, container, false)

        initView(view)
        initSetting()
        initListener()


        return view
    }

    private fun initView(view: View) {
        filterBtn = view.findViewById(R.id.lolmain_filter)
        writeBtn = view.findViewById(R.id.lol_main_write)
        recyclerView = view.findViewById<RecyclerView>(R.id.lol_main_post_list)
    }

    private fun initSetting() {

        var dummyLolPost = mutableListOf<LolPost>(
            LolPost(
                1, "빵만드는브랜드", "일반",
                "같이 게임하실분", 1, 100,
                Date(), 3, 1,
                1, 1, 1, 1,
                1, "같이하실분 ~", Date(), Date(), 1
            ),
            LolPost(
                1, "빵만드는브랜드", "일반",
                "같이 게임하실분", 1, 100,
                Date(), 3, 1,
                1, 1, 1, 1,
                1, "같이하실분 ~", Date(), Date(), 1
            ),
            LolPost(
                1, "빵만드는브랜드", "일반",
                "같이 게임하실분", 1, 100,
                Date(), 3, 1,
                1, 1, 1, 1,
                1, "같이하실분 ~", Date(), Date(), 1
            ),
            LolPost(
                1, "빵만드는브랜드", "일반",
                "같이 게임하실분", 1, 100,
                Date(), 3, 1,
                1, 1, 1, 1,
                1, "같이하실분 ~", Date(), Date(), 1
            ),
            LolPost(
                1, "빵만드는브랜드", "일반",
                "같이 게임하실분", 1, 100,
                Date(), 3, 1,
                1, 1, 1, 1,
                1, "같이하실분 ~", Date(), Date(), 1
            ),
            LolPost(
                1, "빵만드는브랜드", "일반",
                "같이 게임하실분", 1, 100,
                Date(), 3, 1,
                1, 1, 1, 1,
                1, "같이하실분 ~", Date(), Date(), 1
            ),
            LolPost(
                1, "빵만드는브랜드", "일반",
                "같이 게임하실분", 1, 100,
                Date(), 3, 1,
                1, 1, 1, 1,
                1, "같이하실분 ~", Date(), Date(), 1
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = LolPostAdapter(dummyLolPost, activity!!)

    }

    private fun initListener() {
        writeBtn.setOnClickListener {
            val intent = Intent(activity, LolWriteActivity::class.java)
            startActivity(intent)
        }

        filterBtn.setOnClickListener {
            val intent = Intent(activity, LolFilterActivity::class.java)
            startActivity(intent)
        }
    }
}