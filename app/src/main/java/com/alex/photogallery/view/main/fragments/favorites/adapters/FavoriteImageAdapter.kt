package com.alex.photogallery.view.main.fragments.favorites.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alex.photogallery.R
import com.alex.photogallery.databinding.ItemFavoriteImageBinding
import com.alex.photogallery.persistence.entities.FavoriteImageData
import com.alex.photogallery.presenter.main.fragments.favorites.FavoritesPresenter
import com.bumptech.glide.Glide

class FavoriteImageAdapter(var favoritesPresenter: FavoritesPresenter ,var dataList:MutableList<FavoriteImageData>):RecyclerView.Adapter<FavoriteImageHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteImageHolder {
        var inflateView = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_image,parent, false)
        return FavoriteImageHolder(favoritesPresenter, inflateView)
    }

    override fun onBindViewHolder(holder: FavoriteImageHolder, position: Int) {
        holder.binData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}

class FavoriteImageHolder(var favoritesPresenter: FavoritesPresenter , itemView: View):RecyclerView.ViewHolder(itemView) {

    private val binding = ItemFavoriteImageBinding.bind(itemView)

    fun binData(favoriteImageData: FavoriteImageData){
        binding.imageNameTextView.text = favoriteImageData.imageName

        Glide.with(itemView.context)
            .load(favoriteImageData.imageUrl)
            .into(binding.imageHolderView)

        binding.imageButton.setOnClickListener {
            favoritesPresenter.showImageDetails(favoriteImageData)
        }
    }
}
