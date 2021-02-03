package com.linkdev.sample.ui.tabs

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.linkdev.sample.R
import com.linkdev.sample.data.TabItemData
import com.linkdev.sample.data.shared_preference.IPreferenceDataSource
import com.linkdev.sample.databinding.FragmentViewPagerBinding
import com.linkdev.sample.ui.MainActivity
import com.linkdev.sample.ui.RTLViewPagerSampleApplication
import com.linkdev.sample.ui.base.BaseFragment
import com.linkdev.sample.ui.tabs.tabs_item.FragmentTabItem
import com.linkdev.sample.utils.Constants
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
        binding.viewPager.adapter =
            ItemPagerAdapter(childFragmentManager, getFragmentList(), getTabItemData())
        binding.tabLayout.setupWithViewPager(binding.viewPager)
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


    private fun getFragmentList(): ArrayList<Fragment> {
        val fragments: ArrayList<Fragment> = arrayListOf()
        val dataList = getTabItemData()
        for (index in 0 until dataList.size) {
            fragments.add(
                FragmentTabItem.newInstance(
                    dataList[index]
                )
            )
        }
        return fragments
    }

    private fun getTabItemData(): ArrayList<TabItemData> {
        val tabItems = arrayListOf<TabItemData>()
        tabItems.add(TabItemData(getString(R.string.tab_one), getString(R.string.tab1_description)))
        tabItems.add(TabItemData(getString(R.string.tab_two), getString(R.string.tab2_description)))
        tabItems.add(
            TabItemData(
                getString(R.string.tab_three),
                getString(R.string.tab2_description)
            )
        )
        return tabItems
    }
}