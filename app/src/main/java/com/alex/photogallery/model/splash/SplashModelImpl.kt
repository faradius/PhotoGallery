package com.alex.photogallery.model.splash

import android.os.Handler
import com.alex.photogallery.presenter.splash.SplashPresenter

class SplashModelImpl(private var splashPresenter: SplashPresenter):SplashModel {
    override fun checkUserLogin() {
        Handler().postDelayed({
            splashPresenter.onValidateUser(true)
        }, 3000)
    }
}