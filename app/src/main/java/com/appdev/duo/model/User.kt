package com.appdev.duo.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User : RealmObject() {
    @PrimaryKey
    private var id: Int? = null
    private var nickname: String? = null
    private var platform: String? = null
    private var accessToken: String? = null
    private var userToken: String? = null

    fun setId(id: Int) {
        this.id = id
    }

    fun setNickname(id: String) {
        this.nickname = nickname
    }

    fun setPlatform(platform: String) {
        this.platform = platform
    }

    fun setAccessToken(accessToken: String) {
        this.accessToken = accessToken
    }

    fun setUserToken(userToken: String) {
        this.userToken = userToken
    }

    fun getId(): Int? {
        return id
    }

    fun getNickname(): String? {
        return nickname
    }

    fun getPlatform(): String? {
        return nickname
    }

    fun getAccessToken(): String? {
        return accessToken
    }

    fun getUserToken(): String? {
        return userToken
    }


}