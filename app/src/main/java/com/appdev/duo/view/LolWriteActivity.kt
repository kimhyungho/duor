package com.appdev.duo.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.appdev.duo.R
import kotlinx.android.synthetic.main.activity_lol_write.*

class LolWriteActivity : AppCompatActivity() {
    private var isMicSelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lol_write)
        lol_write_select_gamemode.setOnClickListener {
            val manager = supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_right_in, R.anim.slide_left_out,
                    R.anim.slide_left_in, R.anim.slide_right_out
                )
                .replace(R.id.lol_write_container, LolGameModeSelectFragment())
                .addToBackStack(null)
                .commit()
        }

        lol_write_select_position.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            val positionData = arrayListOf<String>("탑", "정글", "미드", "바텀", "서폿")
            val booleanData = arrayListOf<Boolean>(false, false, false, false, false)
            alertDialogBuilder.setTitle("포지션 선택")
            alertDialogBuilder.setPositiveButton(
                "적용"
            ) { p0, p1 -> }
            alertDialogBuilder.setMultiChoiceItems(
                arrayOf("탑", "정글", "미드", "바텀", "서폿"),
                booleanArrayOf(false, false, false, false, false)
            ) { p0, p1, p2 ->

            }
                .show()
        }

        lol_write_select_mic.setOnClickListener {
            isMicSelected = !isMicSelected
            if (isMicSelected) {
                lol_write_mic.text = "마이크 가능"
                lol_write_mic_icon.setImageResource(R.drawable.ic_baseline_mic_24)
            } else {
                lol_write_mic.text = "마이크 불가능"
                lol_write_mic_icon.setImageResource(R.drawable.ic_baseline_mic_off_24)
            }
        }

    }
}