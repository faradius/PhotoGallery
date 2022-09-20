package com.alex.photogallery.presenter.main.fragments.favorites

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alex.photogallery.model.main.fragments.favorites.FavoriteModelImpl
import com.alex.photogallery.model.main.fragments.favorites.FavoritesModel
import com.alex.photogallery.persistence.entities.FavoriteImageData
import com.alex.photogallery.view.main.fragments.favorites.FavoritesView
import com.alex.photogallery.view.main.fragments.favorites.adapters.FavoriteImageAdapter

class FavoritePresenterImpl(private var favoritesView: FavoritesView):FavoritesPresenter {

    private var favoritesModel:FavoritesModel = FavoriteModelImpl(this)

    override fun configureView() {
        favoritesModel.getFavoriteImages()
    }

    override fun onFavoriteImagesLoaded(images: ArrayList<FavoriteImageData>) {
        favoritesView.getRecyclerView().adapter = FavoriteImageAdapter(images)
        //var linearLayoutManager = LinearLayoutManager(favoritesView.getContext())
        //linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        favoritesView.getRecyclerView().layoutManager =GridLayoutManager(favoritesView.getContext(),2)
        favoritesView.onListLoaded()
    }

    override fun getContext(): Context {
        return favoritesView.getContext()
    }
}