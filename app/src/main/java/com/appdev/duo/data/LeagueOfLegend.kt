package com.appdev.duo.data

import java.io.Serializable

class LeagueOfLegendSummoner(
    var id: String,
    var accountId: String,
    var puuid: String,
    var name: String,
    var profileIconId: Int,
    var revisionDate: Int,
    var summonerLevel: Int
) : Serializable

class LeagueOfLegendEntries(
    var leagueId: String,
    var queueType: String,  // 5 vs 5
    var tier: String,  // GOLD
    var rank: String,   // VI
    var summonerId: String,
    var summonerName: String, // "빵만드는브랜드"
    var leaguePoints: Int, // 0
    var wins: Int,
    var losses: Int,
    var veteran: Boolean,
    var inactive: Boolean,
    var freshBlood: Boolean,
    var hotStreak: Boolean
): Serializable