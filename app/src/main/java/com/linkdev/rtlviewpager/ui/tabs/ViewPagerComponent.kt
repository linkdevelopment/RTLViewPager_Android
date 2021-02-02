package com.linkdev.rtlviewpager.ui.tabs

import dagger.Subcomponent

@Subcomponent
interface ViewPagerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ViewPagerComponent
    }

    fun inject(fragmentViewPager: FragmentViewPager)
}