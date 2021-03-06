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
package com.linkdev.sample.ui.tabs.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.linkdev.sample.data.TabItemData

internal class ItemFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    var fragments: ArrayList<Fragment>,
    var tabItems: ArrayList<TabItemData>
) : FragmentPagerAdapter(
    fragmentManager
) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]

    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabItems[position].tabTitle
    }
}