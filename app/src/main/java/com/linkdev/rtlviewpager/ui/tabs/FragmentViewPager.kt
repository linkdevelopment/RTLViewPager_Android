package com.linkdev.rtlviewpager.ui.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.linkdev.rtlviewpager.databinding.FragmentViewPagerBinding
import com.linkdev.rtlviewpager.ui.base.BaseFragment


class FragmentViewPager : BaseFragment<FragmentViewPagerBinding>() {

    companion object {
        const val Tag = "FragmentViewPager"

        @JvmStatic
        fun newInstance() = FragmentViewPager()
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentViewPagerBinding
        get() = FragmentViewPagerBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initViews() {

    }

    override fun setListeners() {
    }


}