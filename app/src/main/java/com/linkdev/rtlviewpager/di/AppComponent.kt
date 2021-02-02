package com.linkdev.rtlviewpager.di

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.linkdev.rtlviewpager.ui.base.BaseActivity

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

}