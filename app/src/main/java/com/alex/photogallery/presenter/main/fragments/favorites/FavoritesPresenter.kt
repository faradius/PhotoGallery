package com.alex.photogallery.presenter.main.fragments.favorites

import android.content.Context
import com.alex.photogallery.persistence.entities.FavoriteImageData

interface FavoritesPresenter {

    fun configureView()
    fun onFavoriteImagesLoaded(images:ArrayList<FavoriteImageData>)
    fun getContext():Context
}