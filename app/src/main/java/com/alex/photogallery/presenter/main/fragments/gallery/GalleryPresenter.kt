package com.alex.photogallery.presenter.main.fragments.gallery

import com.alex.photogallery.persistence.entities.ImageData

interface GalleryPresenter {
    fun configureView()
    fun onServerResponse(images:ArrayList<ImageData>)
}