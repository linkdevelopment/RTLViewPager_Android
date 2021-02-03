package com.linkdev.sample.ui


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.linkdev.sample.databinding.ActivityMainBinding
import com.linkdev.sample.ui.base.BaseActivity
import com.linkdev.sample.ui.tabs.FragmentViewPager

class MainActivity : BaseActivity<ActivityMainBinding>() {
    companion object {
        fun restartActivity(context: Context) {
            val intent = Intent(context,MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }
    }

    override val viewBindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null)
            replaceFragment(
                binding.fragmentContainer.id,
                FragmentViewPager.newInstance(),
                FragmentViewPager.Tag
            )
    }


    override fun initializeViews() {

    }

    override fun setListeners() {

    }

}