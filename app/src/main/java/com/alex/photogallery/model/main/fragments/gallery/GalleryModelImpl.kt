package com.alex.photogallery.model.main.fragments.gallery

import android.os.Handler
import com.alex.photogallery.R
import com.alex.photogallery.persistence.entities.ImageData
import com.alex.photogallery.presenter.main.fragments.gallery.GalleryPresenter


class GalleryModelImpl(private var galleryPresenter: GalleryPresenter):GalleryModel {
    override fun getImagesFromServer() {
        Handler().postDelayed({
            val images = mutableListOf<ImageData>()
            images.add(ImageData(0, R.drawable.image_1, "Katy"))
            images.add(ImageData(1, R.drawable.image_2, "Gio"))
            images.add(ImageData(2, R.drawable.image_1,"Hello"))

            galleryPresenter.onServerResponse(images as ArrayList<ImageData>)
        },2000)
    }
}