package com.alex.photogallery.model.main.fragments.favorites

import com.alex.photogallery.persistence.sqllite.FavoriteImagesDbManager
import com.alex.photogallery.presenter.main.fragments.favorites.FavoritesPresenter

class FavoriteModelImpl(private var favoritesPresenter: FavoritesPresenter):FavoritesModel {
    override fun getFavoriteImages() {
        FavoriteImagesDbManager.getFavoriteImages(favoritesPresenter.getContext()){
            favoritesPresenter.onFavoriteImagesLoaded(it)
        }
    }
}