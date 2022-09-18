package com.alex.photogallery.view.main

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alex.photogallery.R
import com.alex.photogallery.databinding.ActivityMainBinding
import com.alex.photogallery.presenter.main.MainPresenter
import com.alex.photogallery.presenter.main.MainPresenterImpl

class MainActivity : AppCompatActivity(), MainView {

    lateinit var binding: ActivityMainBinding
    private var mainPresenter:MainPresenter=MainPresenterImpl(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeBottom()
        mainPresenter.configureView()
    }

    private fun initializeBottom(){
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            mainPresenter.onBottomClick(it)
            false
        }
    }

    override fun getContext(): Context {
        return this
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun showFragment(fragment: Fragment, fragmentIndex: Int) {
        binding.frameContent.visibility = View.GONE
        supportFragmentManager.beginTransaction().replace(R.id.frameContent, fragment).commit()

        binding.bottomNavigation.menu.getItem(fragmentIndex).setChecked(true)
    }

    override fun showFrame() {
        binding.frameContent.visibility = View.VISIBLE
    }

    override fun showProgressBar() {
        binding.mainProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.mainProgressBar.visibility = View.GONE
    }
}