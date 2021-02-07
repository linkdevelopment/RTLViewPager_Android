/**
Copyright (C) 2020 Link Development

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 **/

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
import com.linkdev.sample.ui.tabs.adapters.ItemFragmentPagerAdapter
import com.linkdev.sample.ui.tabs.adapters.ViewPagerAdapter
import com.linkdev.sample.ui.tabs.tabs_item.FragmentTabItem
import com.linkdev.sample.utils.Constants
import com.linkdev.sample.utils.Constants.Extras.EXAMPLE_TYPE
import javax.inject.Inject


class FragmentViewPager : Fragment() {

    @Inject
    lateinit var iPreferenceDataSource: IPreferenceDataSource
    private var binding: FragmentViewPagerBinding? = null

    companion object {
        const val TAG = "FragmentViewPager"

        @JvmStatic
        fun newInstance(exampleType: Int) = FragmentViewPager().apply {
            arguments = Bundle().apply {
                putInt(EXAMPLE_TYPE, exampleType)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectDependency()
        initViews()
    }

    private fun initViews() {
        initPagerAdapter()
        binding?.tabLayout?.setupWithViewPager(binding?.viewPager)
    }

    private fun initPagerAdapter() {
        when (arguments?.getInt(EXAMPLE_TYPE, Constants.ExampleType.FRAGMENT_TYPE)) {
            Constants.ExampleType.FRAGMENT_TYPE -> initFragmentPagerAdapter()
            Constants.ExampleType.VIEW_TYPE -> initViewPagerAdapter()
        }
    }

    private fun initFragmentPagerAdapter() {
        binding?.viewPager?.adapter =
            ItemFragmentPagerAdapter(childFragmentManager, getFragmentList(), getTabItemData())
    }

    private fun initViewPagerAdapter() {
        binding?.viewPager?.adapter =
            ViewPagerAdapter(context!!)
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
        (context?.applicationContext as RTLViewPagerSampleApplication).appComponent.viewPagerComponent()
            .create().inject(this)
    }

    private fun saveLanguage(language: String) {
        iPreferenceDataSource.setLanguage(language)
        MainActivity.restartActivity(context!!)
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
                getString(R.string.tab3_description)
            )
        )
        return tabItems
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}