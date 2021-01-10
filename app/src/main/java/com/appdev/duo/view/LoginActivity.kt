package com.appdev.duo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.appdev.duo.R
import com.appdev.duo.contract.LoginContract
import com.appdev.duo.network.UserAPI
import com.github.windsekirun.rxsociallogin.RxSocialLogin
import com.github.windsekirun.rxsociallogin.intenal.model.PlatformType
import com.google.gson.JsonObject
import com.kakao.auth.authorization.accesstoken.AccessToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import retrofit2.HttpException

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private var compositeDisposable = CompositeDisposable()
    lateinit var kakaoLoginBtn: ConstraintLayout
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_login)

        initView()
        initSettings()
        initListener()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        RxSocialLogin.activityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun initView() {
        kakaoLoginBtn = login_kakao_button
        progressBar = login_progressbar
    }

    private fun initSettings() {
        RxSocialLogin.initialize(this)

        progressBar.visibility = View.GONE


        RxSocialLogin.result()
            .doOnNext{progressBar.visibility = View.VISIBLE}
            .subscribe({
                val mAccessToken = AccessToken.Factory.getInstance().accessToken
                UserAPI(mAccessToken, null).service
                    .login()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        progressBar.visibility = View.GONE
                        Log.d("result", it.userToken)
                        finish()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }, {
                        if (it is HttpException) {
                            progressBar.visibility = View.GONE
                            val code =
                                JSONObject(it.response()?.errorBody()?.string()).getString("code")
                            when (code) {
                                "-401" -> {
                                    Log.d("result", "-401")
                                }
                                "-412" -> {
                                    Log.d("result", "-412")
                                }
                                "-500" -> {
                                    Log.d("result", "-500")
                                }
                            }
                        }

                    })

            }, {
                Log.e("Error", "LoginError", it)
            }).addTo(compositeDisposable)
    }

    private fun initListener() {
        kakaoLoginBtn.setOnClickListener {
            RxSocialLogin.login(PlatformType.KAKAO)
        }
    }

    override fun showProgressBar() {

    }
}