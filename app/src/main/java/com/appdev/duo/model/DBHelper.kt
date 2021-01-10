package com.appdev.duo.model

import io.realm.Realm
import io.realm.RealmResults

class DBHelper {
    private val ourInstance = DBHelper()

    fun getInstance(): DBHelper {
        return ourInstance
    }

    var realm: Realm? = null

    fun getRealmInstance(): Realm? {
        return realm
    }

    fun insertUser(
        id: Int,
        nickname: String,
        platform: String,
        accessToken: String,
        userToken: String
    ) {
        val user = User()
        user.setId(id)
        user.setNickname(nickname)
        user.setPlatform(platform)
        user.setAccessToken(accessToken)
        user.setUserToken(userToken)

        realm?.beginTransaction()
        realm?.copyFromRealm(user)
        realm?.commitTransaction()
    }

    private fun getUserWithId(id: Int): RealmResults<User>? {
        return realm?.where(User::class.java)?.equalTo("id", id)?.findAll()
    }

    private fun editNickname(
        id: Int,
        nickname: String
    ) {
        val result: RealmResults<User> = getUserWithId(id)!!
        val user: User = result[0]!!
        realm?.beginTransaction()
        user.setNickname(nickname)
        realm?.commitTransaction()

    }

    private fun deleteUser(id: Int) {
        val result: RealmResults<User> = getUserWithId(id) ?: return
        realm?.beginTransaction()
        result.deleteAllFromRealm()
        realm?.commitTransaction()
    }

}