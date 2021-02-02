package com.appdev.duo.view

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.appdev.duo.R
import kotlinx.android.synthetic.main.activity_lol_write.*

class LolWriteActivity : AppCompatActivity() {
    private var isMicSelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lol_write)
        lol_write_select_gamemode.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            val gameModeArray = resources.getStringArray(R.array.gamemode)
            dialog.setTitle("게임모드 선택")
            dialog.setItems(gameModeArray, DialogInterface.OnClickListener { dialogInterface, i ->
                lol_write_gamemode.text = gameModeArray[i]
                lol_write_gamemode.setTextColor(Color.parseColor("#415fce"))
            })
            dialog.create()
            dialog.show()
        }

        lol_write_select_position.setOnClickListener {
            val positionArray = arrayOf("탑", "정글", "미드", "바텀", "서폿")
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("포지션 선택")
            alertDialogBuilder.setMultiChoiceItems(
                positionArray,
                booleanArrayOf(false, false, false, false, false)
            ) { p0, p1, p2 -> }
            alertDialogBuilder.setPositiveButton(
                "적용"
            ) { p0, p1 ->
                Toast.makeText(this, "" + p1, Toast.LENGTH_SHORT).show()
            }
            alertDialogBuilder.create()
            alertDialogBuilder.show()
        }

        lol_write_select_mic.setOnClickListener {
            isMicSelected = !isMicSelected
            if (isMicSelected) {
                lol_write_mic.text = "마이크 가능"
//                lol_write_mic_icon.setImageResource(R.drawable.ic_baseline_mic_24)
            } else {
                lol_write_mic.text = "마이크 불가능"
//                lol_write_mic_icon.setImageResource(R.drawable.ic_baseline_mic_off_24)
            }
        }

    }
}