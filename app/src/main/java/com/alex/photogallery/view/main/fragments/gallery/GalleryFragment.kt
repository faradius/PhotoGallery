package com.alex.photogallery.view.main.fragments.gallery

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex.photogallery.R
import com.alex.photogallery.databinding.FragmentImagesBinding
import com.alex.photogallery.presenter.main.MainPresenter
import com.alex.photogallery.presenter.main.fragments.gallery.GalleryPresenter
import com.alex.photogallery.presenter.main.fragments.gallery.GalleryPresenterImpl
import com.yalantis.library.Koloda


class GalleryFragment(var mainPresenter: MainPresenter) : Fragment(),GalleryView {

    private lateinit var fragmentView: View
    private lateinit var binding: FragmentImagesBinding
    private var galleryPresenter:GalleryPresenter = GalleryPresenterImpl(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_images, container, false)
        binding = FragmentImagesBinding.bind(view)
        fragmentView = view


        galleryPresenter.configureView()

        return view
    }

    override fun getContext(): Context {
        return fragmentView.context
    }

    override fun getFragmentView(): View {
        return fragmentView
    }

    override fun getImagesHolder(): Koloda {
        return binding.imagesHolder
    }

    override fun onImagesLoaded() {
        mainPresenter.fragmentWasLoaded()
    }
}