package com.alex.photogallery.presenter.main

import android.os.Handler
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.alex.photogallery.R
import com.alex.photogallery.view.main.Main
import com.alex.photogallery.view.main.fragments.favorites.FavoritesFragment
import com.alex.photogallery.view.main.fragments.images.ImagesFragment
import com.alex.photogallery.view.main.fragments.settings.SettingsFragment

class MainPresenterImpl(private var main: Main):MainPresenter {
    override fun onBottomClick(menuItem: MenuItem) {

        main.showProgressBar()

        var fragment:Fragment? = null
        var fragmentIndex = 0

        when(menuItem.itemId){
            R.id.navigationFavorites->{
                fragment = FavoritesFragment(this)
                fragmentIndex = 0
            }
            R.id.navigationGallery->{
                fragment = ImagesFragment(this)
                fragmentIndex = 1
            }
            R.id.navigationSettings->{
                fragment = SettingsFragment(this)
                fragmentIndex = 2
            }
        }

        if (fragment!=null){
            main.showFragment(fragment,fragmentIndex)
        }

    }

    override fun fragmentWasLoaded() {
        Handler().postDelayed({
            main.hideProgressBar()
            main.showFrame()
        },500)
    }

    override fun configureView() {
        var fragment = FavoritesFragment(this)
        main.showFragment(fragment,0)
    }
}