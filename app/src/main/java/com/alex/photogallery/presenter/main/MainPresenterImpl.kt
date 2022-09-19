package com.alex.photogallery.presenter.main

import android.os.Handler
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.alex.photogallery.R
import com.alex.photogallery.view.main.MainView
import com.alex.photogallery.view.main.fragments.favorites.FavoritesFragment
import com.alex.photogallery.view.main.fragments.gallery.GalleryFragment
import com.alex.photogallery.view.main.fragments.settings.SettingsFragment

class MainPresenterImpl(private var mainView: MainView):MainPresenter {

    private var currentIndex=0
    private var fragmentIsLoading = false

    override fun onBottomClick(menuItem: MenuItem) {
        if (fragmentIsLoading)return

        fragmentIsLoading=true

        mainView.showProgressBar()

        var fragment:Fragment? = null
        var fragmentIndex = 0

        when(menuItem.itemId){
            R.id.navigationFavorites->{
                fragment = FavoritesFragment(this)
                fragmentIndex = 0
            }
            R.id.navigationGallery->{
                fragment = GalleryFragment(this)
                fragmentIndex = 1
            }
            R.id.navigationSettings->{
                fragment = SettingsFragment(this)
                fragmentIndex = 2
            }
        }

        if (fragment!=null&&currentIndex!=fragmentIndex){

            mainView.showFragment(fragment,fragmentIndex)

        }else if (currentIndex==fragmentIndex){

            mainView.hideProgressBar()
            fragmentIsLoading=false
        }

        currentIndex=fragmentIndex

    }

    override fun fragmentWasLoaded() {
        Handler().postDelayed({
            mainView.hideProgressBar()
            mainView.showFrame()
            fragmentIsLoading=false
        },500)
    }

    override fun configureView() {
        var fragment = FavoritesFragment(this)
        mainView.showFragment(fragment,0)
    }
}