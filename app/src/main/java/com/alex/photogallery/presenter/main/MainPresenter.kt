package com.alex.photogallery.presenter.main

import android.view.MenuItem

interface MainPresenter {
    fun onBottomClick(menuItem: MenuItem)
    fun fragmentWasLoaded()
    fun configureView()
}