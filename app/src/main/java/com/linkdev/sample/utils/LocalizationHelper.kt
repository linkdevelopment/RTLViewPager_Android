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

package com.linkdev.sample.utils

import android.content.Context
import android.text.TextUtils
import com.linkdev.sample.data.shared_preference.IPreferenceDataSource
import java.util.*

object LocalizationHelper {

    private const val DEFAULT_LOCALE: String = Constants.Languages.ENGLISH_LANGUAGE

    fun getLocale(iPreferencesDataSource: IPreferenceDataSource): Locale {
        return getAppLanguage(iPreferencesDataSource)?.let { Locale(it) }!!
    }

    fun getAppLanguage(preferencesDataSource: IPreferenceDataSource): String? {
        return preferencesDataSource.getLanguage(DEFAULT_LOCALE)
    }

    fun changeAppLanguage(ctx: Context, languageToLoad: String) {
        languageToLoad.apply { this.toLowerCase(Locale.getDefault()) }

        try {
            if (!TextUtils.isEmpty(languageToLoad)) {
                val res = ctx.applicationContext.resources
                val config = res.configuration
                val locale = Locale(languageToLoad)
                Locale.setDefault(locale)
                config.setLocale(locale)
            }
        } catch (e: Exception) {

        }
    }

    fun getDefaultNumbersLocale(): Locale = Locale.ENGLISH
}