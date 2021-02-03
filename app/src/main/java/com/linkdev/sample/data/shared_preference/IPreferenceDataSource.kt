package com.linkdev.sample.data.shared_preference


interface IPreferenceDataSource {

    fun getLanguage(defaultLanguage: String): String
    fun setLanguage(languageToLoad: String)
}