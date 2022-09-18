package com.alex.photogallery.view.main

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment

interface MainView {
    fun getContext():Context
    fun getActivity():Activity
    fun showFragment(fragment: Fragment, fragmentIndex: Int)
    fun showFrame()

    fun showProgressBar()
    fun hideProgressBar()
}