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

import android.app.Application
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import com.linkdev.sample.data.shared_preference.IPreferenceDataSource
import com.linkdev.sample.di.AppComponent
import com.linkdev.sample.di.DaggerAppComponent
import com.linkdev.sample.utils.Constants
import java.util.*
import javax.inject.Inject

class RTLViewPagerSampleApplication : Application() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var iPreferenceDataSource: IPreferenceDataSource
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(this)
        appComponent.inject(this)

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        val configuration: Configuration = newConfig
        val appLanguage = iPreferenceDataSource.getLanguage(Constants.Languages.DEFAULT_LANGUAGE)
        if (appLanguage.isNotEmpty()) {
            val newLocale = Locale(appLanguage)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                configuration.apply {
                    val localeList = LocaleList(newLocale)
                    LocaleList.setDefault(localeList)
                    setLocale(newLocale)
                    setLocales(localeList)
                }
            } else {
                configuration.setLocale(newLocale)
            }
        }
        super.onConfigurationChanged(configuration)
    }


}