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
package com.linkdev.sample.ui


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.linkdev.sample.databinding.ActivityMainBinding
import com.linkdev.sample.ui.base.BaseActivity
import com.linkdev.sample.ui.tabs.FragmentViewPager

class MainActivity : BaseActivity<ActivityMainBinding>() {
    companion object {
        fun restartActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }
    }

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