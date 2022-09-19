package com.alex.photogallery.presenter.main.fragments.gallery

import android.content.Context
import com.alex.photogallery.persistence.entities.ImageData

interface GalleryPresenter {
    fun configureView()
    fun getContext():Context
    fun onServerResponse(images:ArrayList<ImageData>)
}