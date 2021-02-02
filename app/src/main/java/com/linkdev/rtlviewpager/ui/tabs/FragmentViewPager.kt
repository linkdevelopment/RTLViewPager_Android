package com.linkdev.rtlviewpager.ui.tabs

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.*
import com.linkdev.rtlviewpager.R
import com.linkdev.rtlviewpager.data.shared_preference.IPreferenceDataSource
import com.linkdev.rtlviewpager.databinding.FragmentViewPagerBinding
import com.linkdev.rtlviewpager.ui.MainActivity
import com.linkdev.rtlviewpager.ui.RTLViewPagerSampleApplication
import com.linkdev.rtlviewpager.ui.base.BaseFragment
import com.linkdev.rtlviewpager.utils.Constants
import javax.inject.Inject


class FragmentViewPager : BaseFragment<FragmentViewPagerBinding>() {

    @Inject
    lateinit var iPreferenceDataSource: IPreferenceDataSource

    companion object {
        const val Tag = "FragmentViewPager"

        @JvmStatic
        fun newInstance() = FragmentViewPager()
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentViewPagerBinding
        get() = FragmentViewPagerBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectDependency()
    }

    override fun initViews() {

    }

    override fun setListeners() {
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_english -> saveLanguage(Constants.Languages.ENGLISH_LANGUAGE)
            R.id.action_arabic -> saveLanguage(Constants.Languages.ARABIC_LANGUAGE)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun injectDependency() {
        (mContext.applicationContext as RTLViewPagerSampleApplication).appComponent.viewPagerComponent()
            .create().inject(this)
    }

    private fun saveLanguage(language: String) {
        iPreferenceDataSource.setLanguage(language)
        MainActivity.restartActivity(mContext)
    }
}