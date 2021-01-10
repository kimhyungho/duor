package com.appdev.duo.data

import java.io.Serializable
import java.util.*

class LolPost(
    var id : Int,
    var nickname : String,
    var gameMode: String,
    var title: String,
    var startTier: Int,
    var endTier: Int,
    var endTime: Date,
    var headCount: Int,
    var top: Int,
    var jungle: Int,
    var mid: Int,
    var bottom : Int,
    var support: Int,
    var talkon: Int,
    var content: String,
    var createAt: Date,
    var updateAt: Date,
    var userId: Int
):Serializable