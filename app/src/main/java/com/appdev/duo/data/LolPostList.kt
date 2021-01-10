package com.appdev.duo.data

import com.google.gson.annotations.SerializedName

class LolPostList {
    @SerializedName("lol_posts")
    private var lolPostList: ArrayList<LolPost>? = null

    fun getLolPostList(): ArrayList<LolPost>? {
        return lolPostList
    }

    fun setLolPostList(lolPostList: ArrayList<LolPost>) {
        this.lolPostList = lolPostList
    }

}