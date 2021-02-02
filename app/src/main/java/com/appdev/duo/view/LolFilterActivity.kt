package com.appdev.duo.view

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.appdev.duo.R
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_lol_filter.*
import org.w3c.dom.Text

class LolFilterActivity : AppCompatActivity() {
    lateinit var normalBtn: TextView
    lateinit var soloRankBtn: TextView
    lateinit var freeRankBtn: TextView
    lateinit var knifeBtn: TextView
    lateinit var customBtn: TextView
    lateinit var tierBtn: ConstraintLayout
    lateinit var tierText: TextView
    lateinit var tierArrow: ImageView
    lateinit var headcountSlider: Slider
    lateinit var headcountText: TextView


    private var isSelectedNormal: Boolean = false
    private var isSelectedSoloRank: Boolean = false
    private var isSelectedFreeRank: Boolean = false
    private var isSelectedKnife: Boolean = false
    private var isSelectedCustom: Boolean = false
    private var isSelectedTier: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lol_filter)

        initView()
        initSetting()
        initListener()
    }


    private fun initView() {
        normalBtn = lol_filter_normal
        soloRankBtn = lol_filter_solo_rank
        freeRankBtn = lol_filter_free_rank
        knifeBtn = lol_filter_knife
        customBtn = lol_filter_custom
        tierBtn = lol_filter_tier_box
        tierText = lol_filter_tier
        tierArrow = lol_filter_tier_icon
        headcountSlider = lol_filter_headcount_slider
        headcountText = lol_filter_headcount_comment
    }

    private fun initSetting() {

    }

    private fun initListener() {
        normalBtn.setOnClickListener {
            isSelectedNormal = !isSelectedNormal
            if (isSelectedNormal) {
                normalBtn.setBackgroundResource(R.drawable.button_selected_filter)
                normalBtn.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                normalBtn.setBackgroundResource(R.drawable.button_no_selected_filter)
                normalBtn.setTextColor(Color.parseColor("#808080"))
            }
        }

        soloRankBtn.setOnClickListener {
            isSelectedSoloRank = !isSelectedSoloRank
            if (isSelectedSoloRank) {
                soloRankBtn.setBackgroundResource(R.drawable.button_selected_filter)
                soloRankBtn.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                soloRankBtn.setBackgroundResource(R.drawable.button_no_selected_filter)
                soloRankBtn.setTextColor(Color.parseColor("#808080"))
            }

        }

        freeRankBtn.setOnClickListener {
            isSelectedFreeRank = !isSelectedFreeRank
            if (isSelectedFreeRank) {
                freeRankBtn.setBackgroundResource(R.drawable.button_selected_filter)
                freeRankBtn.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                freeRankBtn.setBackgroundResource(R.drawable.button_no_selected_filter)
                freeRankBtn.setTextColor(Color.parseColor("#808080"))
            }
        }

        knifeBtn.setOnClickListener {
            isSelectedKnife = !isSelectedKnife
            if (isSelectedKnife) {
                knifeBtn.setBackgroundResource(R.drawable.button_selected_filter)
                knifeBtn.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                knifeBtn.setBackgroundResource(R.drawable.button_no_selected_filter)
                knifeBtn.setTextColor(Color.parseColor("#808080"))
            }
        }

        customBtn.setOnClickListener {
            isSelectedCustom = !isSelectedCustom
            if (isSelectedCustom) {
                customBtn.setBackgroundResource(R.drawable.button_selected_filter)
                customBtn.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                customBtn.setBackgroundResource(R.drawable.button_no_selected_filter)
                customBtn.setTextColor(Color.parseColor("#808080"))
            }
        }

        tierBtn.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            val tierArray = resources.getStringArray(R.array.tier)
            dialog.setTitle("티어")
            dialog.setItems(tierArray, DialogInterface.OnClickListener { dialogInterface, i ->
                tierText.text = tierArray[i]
                tierText.setTextColor(Color.parseColor("#FFFFFF"))
                tierArrow.setColorFilter(Color.parseColor("#FFFFFF"))
                tierBtn.setBackgroundResource(R.drawable.button_selected_filter)
            })
            dialog.create()
            dialog.show()

        }

        headcountSlider.addOnChangeListener { slider, value, fromUser ->
            headcountText.text = "" + value.toInt() + "명 이상"
        }

    }


}