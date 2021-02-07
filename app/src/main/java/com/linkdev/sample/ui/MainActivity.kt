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
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.linkdev.sample.databinding.ActivityMainBinding
import com.linkdev.sample.ui.select.FragmentSelection
import com.linkdev.sample.ui.select.ISelectFragmentListener
import com.linkdev.sample.ui.tabs.FragmentViewPager
import com.linkdev.sample.utils.Constants
import com.linkdev.sample.utils.Constants.ExampleType.FRAGMENT_TYPE
import com.linkdev.sample.utils.Constants.ExampleType.VIEW_TYPE
import com.linkdev.sample.utils.LocaleContextWrapper
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), ISelectFragmentListener {

    private var binding: ActivityMainBinding? = null

    @Inject
    @Named(Constants.NamedAnnotations.LANGUAGE)
    lateinit var mAppLanguage: String

    companion object {
        fun restartActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(requireNotNull(binding?.root))
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(
                    binding?.fragmentContainer?.id!!, FragmentSelection.newInstance(),
                    FragmentSelection.TAG
                )
                .commit()
        else {
            loadFragmentByTag(FragmentSelection.TAG)
        }

    }


    // Localization
    override fun attachBaseContext(mNewBase: Context) {
        var newBase = mNewBase
        (newBase.applicationContext as RTLViewPagerSampleApplication).appComponent.inject(this)

        newBase = LocaleContextWrapper.wrap(newBase, mAppLanguage)

        super.attachBaseContext(newBase)
    }


    override fun onSelectFragment(exampleType: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                binding?.fragmentContainer?.id!!,
                FragmentViewPager.newInstance(exampleType),
                FragmentViewPager.TAG
            )
            .addToBackStack(null)
            .commit()
    }


    private fun loadFragmentByTag(tag: String) {
        supportFragmentManager.findFragmentByTag(tag)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}