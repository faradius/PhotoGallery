package com.alex.photogallery.view.main.fragments.favorites

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.photogallery.R
import com.alex.photogallery.databinding.FragmentFavoritesBinding
import com.alex.photogallery.presenter.main.MainPresenter
import com.alex.photogallery.presenter.main.fragments.favorites.FavoritePresenterImpl
import com.alex.photogallery.presenter.main.fragments.favorites.FavoritesPresenter


class FavoritesFragment(var mainPresenter: MainPresenter) : Fragment(),FavoritesView {

    private lateinit var fragmentView: View
    private var favoritesPresenter:FavoritesPresenter = FavoritePresenterImpl(this)
    private lateinit var binding:FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_favorites, container, false)
        binding = FragmentFavoritesBinding.bind(view)
        fragmentView = view
        favoritesPresenter.configureView()
        return view
    }

    override fun getContext(): Context {
        return fragmentView.context
    }

    override fun getFragmentView(): View {
        return fragmentView
    }

    override fun onListLoaded() {
        mainPresenter.fragmentWasLoaded()
    }

    override fun getRecyclerView(): RecyclerView {
        return binding.favoritesList
    }

    override fun getFragmentLayoutInflater(): LayoutInflater {
        return requireActivity().layoutInflater
    }

}