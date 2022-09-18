package com.alex.photogallery.view.main.fragments.gallery

import android.content.Context
import android.view.View
import com.yalantis.library.Koloda

interface GalleryView {
    fun getContext():Context
    fun getFragmentView():View
    fun getImagesHolder():Koloda
    fun onImagesLoaded()

}