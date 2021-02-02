package com.appdev.duo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.appdev.duo.R
import com.appdev.duo.adapter.MainViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewpager: ViewPager2
    lateinit var tablayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager = main_viewpager
        tablayout = main_tablayout

        viewpager.adapter = MainViewPagerAdapter(this)
        TabLayoutMediator(tablayout, viewpager) {tab, position->
            val viewPagerText = arrayListOf<String>(
                "홈",
                "채팅",
                "내 정보"
            )

            tab.setText(viewPagerText[position])
        }.attach()


//        initView()
//        initSettings()
//        initListener()

    }

    private fun initView() {
    }

    private fun initSettings() {

    }

    private fun initListener() {

    }


}