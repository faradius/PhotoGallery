package com.alex.photogallery.view.main.fragments.favorites

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface FavoritesView {

    fun getContext():Context
    fun getFragmentView():View
    fun onListLoaded()
    fun getRecyclerView():RecyclerView
}