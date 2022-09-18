package com.alex.photogallery.view.main.fragments.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex.photogallery.R
import com.alex.photogallery.presenter.main.MainPresenter

class SettingsFragment(var mainPresenter: MainPresenter) : Fragment() {

    lateinit var fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_settings, container, false)
        fragmentView = view
        mainPresenter.fragmentWasLoaded()
        return view
    }
}