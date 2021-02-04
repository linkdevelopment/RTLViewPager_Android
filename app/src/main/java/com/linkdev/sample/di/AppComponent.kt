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

package com.linkdev.sample.di

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.linkdev.sample.ui.RTLViewPagerSampleApplication
import com.linkdev.sample.ui.base.BaseActivity
import com.linkdev.sample.ui.tabs.ViewPagerComponent

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }


    fun inject(baseActivity: BaseActivity<@JvmSuppressWildcards ViewBinding>?)
    fun viewPagerComponent(): ViewPagerComponent.Factory
    fun inject(rtlViewPagerSampleApplication: RTLViewPagerSampleApplication)

}