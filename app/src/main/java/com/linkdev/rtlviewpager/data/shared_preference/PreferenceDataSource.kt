package com.linkdev.rtlviewpager.data.shared_preference

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.linkdev.rtlviewpager.utils.Constants
import com.linkdev.rtlviewpager.utils.Constants.AppPreference.APP_LOCALE_KEY


class PreferenceDataSource(context: Context) : IPreferenceDataSource {


    private val mPerf: SharedPreferences =
        context.getSharedPreferences(Constants.AppPreference.SHARED_PREFERENCE_NAME, MODE_PRIVATE)


    private fun getString(key: String, defaultValue: String): String? {
        return mPerf.getString(key, defaultValue)
    }

    private fun setString(key: String, value: String?) {
        mPerf.edit().putString(key, value).apply()
    }

    override fun getLanguage(defaultLanguage: String): String {
        return getString(APP_LOCALE_KEY, defaultLanguage) ?: defaultLanguage
    }

    override fun setLanguage(languageToLoad: String) {
        setString(APP_LOCALE_KEY, languageToLoad)
    }



}