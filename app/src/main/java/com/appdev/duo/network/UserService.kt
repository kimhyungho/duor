package com.appdev.duo.network

import com.appdev.duo.data.User
import io.reactivex.Single
import retrofit2.http.Header
import retrofit2.http.POST


interface UserService {

    @POST("/auth/kakao")
    fun login(
        @Header("Authorization") accessToken: String
    ): Single<User>


}