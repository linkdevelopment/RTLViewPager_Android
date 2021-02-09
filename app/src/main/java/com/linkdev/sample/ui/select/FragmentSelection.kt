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
package com.linkdev.sample.ui.select

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.linkdev.sample.R
import com.linkdev.sample.databinding.FragmentSelectionBinding
import com.linkdev.sample.ui.tabs.FragmentViewPager
import com.linkdev.sample.utils.Constants.ExampleType.FRAGMENT_TYPE
import com.linkdev.sample.utils.Constants.ExampleType.VIEW_TYPE


class FragmentSelection : Fragment() {

    private var binding: FragmentSelectionBinding? = null
    private lateinit var mListener: ISelectFragmentListener

    companion object {
        const val TAG = "FragmentSelection"

        @JvmStatic
        fun newInstance() =
            FragmentSelection()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as ISelectFragmentListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectionBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        binding?.btnFragment?.setOnClickListener { onButtonClicked(FRAGMENT_TYPE) }
        binding?.btnView?.setOnClickListener { onButtonClicked(VIEW_TYPE) }

    }

    private fun onButtonClicked(buttonType: Int) {

        mListener.onSelectFragment(buttonType)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}