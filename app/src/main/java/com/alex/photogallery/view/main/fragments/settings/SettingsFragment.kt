package com.alex.photogallery.view.main.fragments.settings

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex.photogallery.R
import com.alex.photogallery.databinding.FragmentSettingsBinding
import com.alex.photogallery.presenter.main.MainPresenter
import com.alex.photogallery.presenter.main.fragments.settings.SettingsPresenter
import com.alex.photogallery.presenter.main.fragments.settings.SettingsPresenterImpl

class SettingsFragment(var mainPresenter: MainPresenter) : Fragment(), SettingsView {

    private lateinit var fragmentView: View
    private var settingsPresenter:SettingsPresenter = SettingsPresenterImpl(this)
    private lateinit var binding:FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_settings, container, false)
        binding = FragmentSettingsBinding.bind(view)
        fragmentView = view
        mainPresenter.fragmentWasLoaded()

        initButtons()

        return view
    }

    private fun initButtons(){
        binding.aboutButton.setOnClickListener {
            settingsPresenter.onAboutButtonClick()
        }
        binding.shareAppButton.setOnClickListener {
            settingsPresenter.onShareAppButtonClick()
        }

        binding.rateAppButton.setOnClickListener {
            settingsPresenter.onRateAppButtonClick()
        }
    }

    override fun getContext(): Context {
        return fragmentView.context
    }

    override fun getFragmentView(): View {
        return fragmentView
    }

    override fun getFragmentLayoutInflater(): LayoutInflater {
        return requireActivity().layoutInflater
    }

}