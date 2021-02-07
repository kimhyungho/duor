package com.appdev.duo.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.appdev.duo.R
import com.appdev.duo.adapter.MyInfoListAdapter
import kotlinx.android.synthetic.main.fragment_my_info.*
import org.w3c.dom.Text

class MyInfoFragment() : Fragment() {
    lateinit var myInfoList: ListView
    lateinit var registerLolBtn: ConstraintLayout

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

        initView(view)
        initSetting()
        initListener()


        return view
    }

    private fun initView(view: View) {
        myInfoList = view.findViewById(R.id.myinfo_listview)
        registerLolBtn = view.findViewById(R.id.myinfo_register_lol)
    }

    private fun initSetting() {
        val nameList = arrayListOf<String>("알림설정", "내가 쓴 글", "공지사항", "버전 및 개발")
        myInfoList.adapter = MyInfoListAdapter(activity as Context, nameList)

    }

    private fun initListener() {

        registerLolBtn.setOnClickListener {
            val intent = Intent(activity, RegisterGameNicknameActivity::class.java)
            startActivity(intent)
        }

    }
}