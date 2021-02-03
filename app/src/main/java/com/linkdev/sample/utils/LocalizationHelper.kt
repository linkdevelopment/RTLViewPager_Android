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