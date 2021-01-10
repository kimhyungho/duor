package com.appdev.duo.application

import android.app.Application
import com.github.windsekirun.rxsociallogin.initSocialLogin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()


        initSocialLogin {
            kakao {
                requireAgeRange = false
                requireBirthday = false
                requireEmail = false
                requireGender = false
            }
        }
    }
}