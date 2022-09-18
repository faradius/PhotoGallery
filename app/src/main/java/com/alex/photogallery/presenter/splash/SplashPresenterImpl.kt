package com.alex.photogallery.presenter.splash

import android.content.Intent
import com.alex.photogallery.model.splash.SplashModel
import com.alex.photogallery.model.splash.SplashModelImpl
import com.alex.photogallery.view.main.MainActivity
import com.alex.photogallery.view.splash.SplashView

class SplashPresenterImpl(private var splashView: SplashView):SplashPresenter {

    private var splashModel:SplashModel = SplashModelImpl(this)

    override fun launchNextActivity() {
        splashModel.checkUserLogin()
    }

    override fun onValidateUser(isValid: Boolean) {
        var intent = Intent(splashView.getContext(), MainActivity::class.java)
        splashView.getContext().startActivity(intent)

        splashView.getActivity().finish()

    }
}