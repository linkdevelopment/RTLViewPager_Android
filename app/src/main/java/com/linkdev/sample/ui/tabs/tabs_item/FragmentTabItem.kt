package com.linkdev.sample.ui.tabs.tabs_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.linkdev.sample.data.TabItemData
import com.linkdev.sample.databinding.FragmentTabItemBinding
import com.linkdev.sample.ui.base.BaseFragment
import com.linkdev.sample.utils.Constants.Extras.TAB_ITEM


class FragmentTabItem : BaseFragment<FragmentTabItemBinding>() {

    companion object {

        @JvmStatic
        fun newInstance(tabItemData: TabItemData) =
            FragmentTabItem().apply {
                arguments = Bundle().apply {
                    putParcelable(TAB_ITEM, tabItemData)
                }
            }
    }


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTabItemBinding
        get() = FragmentTabItemBinding::inflate

    override fun initViews() {

    }

    override fun setListeners() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            bindDataToViews(it.getParcelable<TabItemData>(TAB_ITEM))
        }
    }

    private fun bindDataToViews(tabItemData: TabItemData?) {
        binding.txtDescription.text = tabItemData?.itemDescription
    }


}