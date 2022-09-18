package com.alex.photogallery.view.main.fragments.settings

import android.content.Context
import android.view.LayoutInflater
import android.view.View

interface SettingsView {
    fun getContext():Context
    fun getFragmentView():View
    fun getFragmentLayoutInflater():LayoutInflater

}