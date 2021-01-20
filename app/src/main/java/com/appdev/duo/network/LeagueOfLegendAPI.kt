package com.appdev.duo.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LeagueOfLegendAPI {

    var service: LeagueOfLegendService


    private val BASE_URL = "https://kr.api.riotgames.com"

    init {
//        val header = Interceptor {
//            val origin = it.request()
//            val token = getToken(accessToken, userToken)
//            val request = origin.newBuilder()
//                .header("Authorization", token)
//                .build()
//            it.proceed(request)
//        }

        val client = OkHttpClient.Builder()
//            .addInterceptor(header)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(LeagueOfLegendService::class.java)
    }


//    private fun getToken(accessToken: String?, userToken: String?): String? {
//        return userToken ?: accessToken
//    }

}