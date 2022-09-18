package com.alex.photogallery.presenter.main.fragments.gallery

import com.alex.photogallery.model.main.fragments.gallery.GalleryModel
import com.alex.photogallery.model.main.fragments.gallery.GalleryModelImpl
import com.alex.photogallery.persistence.entities.ImageData
import com.alex.photogallery.view.main.fragments.gallery.GalleryView

class GalleryPresenterImpl(private var galleryView: GalleryView):GalleryPresenter {

    private var galleryModel:GalleryModel = GalleryModelImpl(this)

    override fun configureView() {

    }

    override fun onServerResponse(images: ArrayList<ImageData>) {

    }
}