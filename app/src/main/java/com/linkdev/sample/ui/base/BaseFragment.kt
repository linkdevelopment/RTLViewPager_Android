package com.linkdev.sample.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected lateinit var mContext: Context

    private var mViewBinding: ViewBinding? = null


    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB


    protected abstract fun initViews()

    protected abstract fun setListeners()

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = mViewBinding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(mViewBinding).root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null)
            mContext = this.activity as Context

        initViews()
        setListeners()
    }


    private fun clearViewBinding() {
        mViewBinding = null
    }

    override fun onDestroyView() {
        clearViewBinding()
        super.onDestroyView()
    }
}
