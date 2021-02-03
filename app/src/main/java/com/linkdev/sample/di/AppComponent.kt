package com.linkdev.sample.di

import android.content.Context
import androidx.viewbinding.ViewBinding
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

}