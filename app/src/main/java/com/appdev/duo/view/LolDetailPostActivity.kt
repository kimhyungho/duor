package com.appdev.duo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.appdev.duo.R
import com.appdev.duo.network.LeagueOfLegendAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class LolDetailPostActivity : AppCompatActivity() {
    private var summonerCompositeDisposable = CompositeDisposable()
    private var entriesCompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lol_detail_post)

        LeagueOfLegendAPI().service.getSummoner(
            "빵만드는브랜드",
            "RGAPI-0d7e3a08-e437-4645-a06d-96ff04588fd4"
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                LeagueOfLegendAPI().service.getEntries(
                    it.id,
                    "RGAPI-0d7e3a08-e437-4645-a06d-96ff04588fd4"
                ).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.d("kkkk", it[0].rank)
                    }, {

                    }).addTo(entriesCompositeDisposable)

            }, {
                Log.e("kkkk", "error", it)
            }).addTo(summonerCompositeDisposable)


    }

    override fun onDestroy() {
        super.onDestroy()
        summonerCompositeDisposable.clear()
        entriesCompositeDisposable.clear()
    }

    private fun initView(view: View) {

    }

    private fun initListener() {

    }
}