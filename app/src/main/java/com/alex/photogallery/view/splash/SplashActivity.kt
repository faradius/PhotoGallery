package com.alex.photogallery.view.splash

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alex.photogallery.R
import com.alex.photogallery.presenter.splash.SplashPresenter
import com.alex.photogallery.presenter.splash.SplashPresenterImpl

class SplashActivity : AppCompatActivity(), SplashView {

    private var splashPresenter:SplashPresenter = SplashPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashPresenter.launchNextActivity()
    }

    override fun getContext(): Context {
        return this
    }

    override fun getActivity(): Activity {
        return this
    }
}