package com.appdev.duo.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserAPI {

    var service: UserService


    private val BASE_URL = "http://ec2-18-222-143-156.us-east-2.compute.amazonaws.com:3000"

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

        service = retrofit.create(UserService::class.java)
    }


//    private fun getToken(accessToken: String?, userToken: String?): String? {
//        return userToken ?: accessToken
//    }

}