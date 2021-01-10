package com.appdev.duo.model

import com.appdev.duo.network.UserAPI
import com.appdev.duo.network.UserService
import com.github.windsekirun.rxsociallogin.RxSocialLogin
import com.github.windsekirun.rxsociallogin.intenal.model.LoginResultItem
import com.kakao.auth.authorization.accesstoken.AccessToken

class UserModel {
    private var service: UserService? = null
    private val appDataBase: DBHelper by lazy {
        DBHelper().getInstance()
    }

    init {
//        service = UserAPI().service
    }

    fun login() {
        RxSocialLogin.result()
            .doOnNext { }
            .subscribe({
                val mAccessToken = AccessToken.Factory.getInstance().accessToken
//                service.login()
            }, {

            })
    }

    fun saveUserDB() {

    }

    fun clearUserDB() {

    }


}