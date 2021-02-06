package com.appdev.duo.network

import com.appdev.duo.data.LeagueOfLegendEntries
import com.appdev.duo.data.LeagueOfLegendSummoner
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LeagueOfLegendService {

    @GET("lol/summoner/v4/summoners/by-name/{nickname}")
    fun getSummoner(
        @Path("nickname") nickname: String,
        @Query("api_key") api_key: String
    ): Single<LeagueOfLegendSummoner>

    @GET("lol/league/v4/entries/by-summoner/{id}")
    fun getEntries(
        @Path("id") id: String,
        @Query("api_key") api_key: String
    ): Single<Array<LeagueOfLegendEntries>>
}