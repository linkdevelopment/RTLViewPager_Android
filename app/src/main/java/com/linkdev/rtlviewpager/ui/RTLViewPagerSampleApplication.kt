package com.linkdev.rtlviewpager.ui

import android.app.Application
import com.linkdev.rtlviewpager.di.AppComponent
import com.linkdev.rtlviewpager.di.DaggerAppComponent

class RTLViewPagerSampleApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(this)

    }

}