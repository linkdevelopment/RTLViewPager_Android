package com.linkdev.rtlviewpager.ui


import android.os.Bundle
import android.view.LayoutInflater
import com.linkdev.rtlviewpager.databinding.ActivityMainBinding
import com.linkdev.rtlviewpager.ui.base.BaseActivity
import com.linkdev.rtlviewpager.ui.tabs.FragmentViewPager

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val viewBindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null)
            replaceFragment(
                binding.fragmentContainer.id,
                FragmentViewPager.newInstance(),
                FragmentViewPager.Tag
            )
    }

    override fun initializeViews() {

    }

    override fun setListeners() {

    }

}