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

package com.linkdev.sample.ui.tabs.tabs_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.linkdev.sample.data.TabItemData
import com.linkdev.sample.databinding.FragmentTabItemBinding
import com.linkdev.sample.utils.Constants.Extras.TAB_ITEM


class FragmentTabItem : Fragment() {

    private var binding: FragmentTabItemBinding? = null

    companion object {

        @JvmStatic
        fun newInstance(tabItemData: TabItemData) =
            FragmentTabItem().apply {
                arguments = Bundle().apply {
                    putParcelable(TAB_ITEM, tabItemData)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabItemBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            bindDataToViews(it.getParcelable<TabItemData>(TAB_ITEM))
        }
    }

    private fun bindDataToViews(tabItemData: TabItemData?) {
        binding?.txtDescription?.text = tabItemData?.itemDescription
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}