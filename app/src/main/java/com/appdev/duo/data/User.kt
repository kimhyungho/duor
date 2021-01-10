package com.appdev.duo.data

import com.google.gson.annotations.SerializedName


class User(
    @field:SerializedName("userToken") val userToken: String,
    @field:SerializedName("nickname") val nickname: String,
    @field:SerializedName("userId") val userId: Int
)
