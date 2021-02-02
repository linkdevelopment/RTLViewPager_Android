package com.linkdev.rtlviewpager.data.shared_preference


interface IPreferenceDataSource {

    fun getLanguage(defaultLanguage: String): String
    fun setLanguage(languageToLoad: String)
}