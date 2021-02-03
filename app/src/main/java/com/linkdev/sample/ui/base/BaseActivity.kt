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

package com.linkdev.sample.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.linkdev.sample.ui.RTLViewPagerSampleApplication
import com.linkdev.sample.utils.Constants
import com.linkdev.sample.utils.LocaleContextWrapper
import javax.inject.Inject
import javax.inject.Named

abstract class BaseActivity<out VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var mContext: Context

    private var mViewBinding: VB? = null

    protected abstract val viewBindingInflater: (LayoutInflater) -> VB

    @Inject
    @Named(Constants.NamedAnnotations.LANGUAGE)
    lateinit var mAppLanguage: String

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = mViewBinding as VB

    protected abstract fun initializeViews()

    protected abstract fun setListeners()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = viewBindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(mViewBinding).root)
        mContext = this
        initializeViews()
        setListeners()
    }

    // Replace/Add Fragment
    protected fun replaceFragment(
        containerId: Int, fragment: Fragment, tag: String,
        shouldAddToBackStack: Boolean = false, backStackTag: String? = null
    ) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (shouldAddToBackStack)
            fragmentTransaction.addToBackStack(backStackTag)
        fragmentTransaction.replace(containerId, fragment, tag)
            .commit()
    }

    // Localization
    override fun attachBaseContext(mNewBase: Context) {
        var newBase = mNewBase
        (newBase.applicationContext as RTLViewPagerSampleApplication).appComponent.inject(this)

        newBase = LocaleContextWrapper.wrap(newBase, mAppLanguage)

        super.attachBaseContext(newBase)
    }
}