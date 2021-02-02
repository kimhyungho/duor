package com.appdev.duo.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appdev.duo.R
import com.appdev.duo.data.LolPost
import com.appdev.duo.view.LolDetailPostActivity
import kotlinx.android.synthetic.main.item_lol_post.view.*

class LolPostAdapter(val lolPostList: List<LolPost>, val activity: Activity) : RecyclerView.Adapter<LolPostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LolPostViewHolder {
        return LolPostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_lol_post, parent, false))
    }

    override fun getItemCount(): Int {
        return lolPostList.size
    }

    override fun onBindViewHolder(holder: LolPostViewHolder, position: Int) {
        val item = lolPostList[position]
        holder.gameMode.text = item.gameMode
        holder.headcount.text = "인원 ${item.headCount}명"
        holder.tier.text = "${item.startTier}~${item.endTier}"
        holder.title.text = item.title
        holder.time.text = "15분전"
//        if(item.talkon == 1) holder.mic.setImageResource(R.drawable.ic_baseline_mic_24)
//        else holder.mic.setImageResource(R.drawable.ic_baseline_mic_off_24)

        holder.itemView.setOnClickListener {
            val intent = Intent(activity, LolDetailPostActivity::class.java)
            activity.startActivity(intent)
        }
    }
}

class LolPostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val gameMode = itemView.findViewById<TextView>(R.id.lol_item_game_mode)
    val tier = itemView.findViewById<TextView>(R.id.lol_item_tier)
    val headcount = itemView.findViewById<TextView>(R.id.lol_item_headcount)
    val title = itemView.findViewById<TextView>(R.id.lol_item_title)
    val time = itemView.findViewById<TextView>(R.id.lol_item_time)
}