package com.alex.photogallery.presenter.main.fragments.favorites

import android.app.AlertDialog
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alex.photogallery.R
import com.alex.photogallery.databinding.FragmentFavoritesBinding
import com.alex.photogallery.databinding.ItemDetailImageFavoriteBinding
import com.alex.photogallery.model.main.fragments.favorites.FavoriteModelImpl
import com.alex.photogallery.model.main.fragments.favorites.FavoritesModel
import com.alex.photogallery.persistence.entities.FavoriteImageData
import com.alex.photogallery.view.main.fragments.favorites.FavoritesView
import com.alex.photogallery.view.main.fragments.favorites.adapters.FavoriteImageAdapter
import com.bumptech.glide.Glide

class FavoritePresenterImpl(private var favoritesView: FavoritesView):FavoritesPresenter {

    private var favoritesModel:FavoritesModel = FavoriteModelImpl(this)
    private lateinit var binding:ItemDetailImageFavoriteBinding

    override fun configureView() {
        favoritesModel.getFavoriteImages()
    }

    override fun onFavoriteImagesLoaded(images: ArrayList<FavoriteImageData>) {
        favoritesView.getRecyclerView().adapter = FavoriteImageAdapter(this,images)
        favoritesView.getRecyclerView().layoutManager =GridLayoutManager(favoritesView.getContext(),2)
        favoritesView.onListLoaded()
    }

    override fun getContext(): Context {
        return favoritesView.getContext()
    }

    override fun showImageDetails(favoriteImageData: FavoriteImageData) {
        val dialog = AlertDialog.Builder(favoritesView.getContext())
        val inflater = favoritesView.getFragmentLayoutInflater()

        var dialogView = inflater.inflate(R.layout.item_detail_image_favorite,null)
        binding = ItemDetailImageFavoriteBinding.bind(dialogView)

        Glide.with(dialogView.context)
            .load(favoriteImageData.imageUrl)
            .into(binding.imageDetailsHolder)

        dialog.setView(dialogView)
        dialog.create()
        dialog.show()
    }
}