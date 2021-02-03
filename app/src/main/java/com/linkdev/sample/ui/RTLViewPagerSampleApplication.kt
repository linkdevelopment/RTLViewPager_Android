package com.linkdev.sample.ui

import android.app.Application
import com.linkdev.sample.di.AppComponent
import com.linkdev.sample.di.DaggerAppComponent

class RTLViewPagerSampleApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(this)

    }

}