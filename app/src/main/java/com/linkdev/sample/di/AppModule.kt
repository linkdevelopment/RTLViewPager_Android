package com.linkdev.sample.di

import android.app.Application
import android.content.Context
import com.linkdev.sample.data.shared_preference.IPreferenceDataSource
import com.linkdev.sample.data.shared_preference.PreferenceDataSource
import com.linkdev.sample.ui.RTLViewPagerSampleApplication
import com.linkdev.sample.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideApplication(application: Application): RTLViewPagerSampleApplication =
        application as RTLViewPagerSampleApplication


    @Provides
    @Singleton
    fun providePreferenceDataSource(context: Context): IPreferenceDataSource {
        return PreferenceDataSource(context)
    }

    @Provides
    @Named(Constants.NamedAnnotations.LANGUAGE)
    fun provideLanguage(iPreferenceDataSource: IPreferenceDataSource): String {
        return iPreferenceDataSource.getLanguage(Constants.Languages.DEFAULT_LANGUAGE)
    }
}