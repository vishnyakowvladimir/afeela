package com.example.core.presentation.fragment

import androidx.fragment.app.Fragment
import com.example.core.presentation.activity.BaseActivity

abstract class BaseFragment : Fragment() {
    open fun onBackPressed() {}

    protected fun setTitle(title: String?) {
        activity?.title = title.orEmpty()
    }

    protected fun setTitle(titleResource: Int) {
        activity?.title = requireContext().getString(titleResource)
    }

    protected fun setDisplayHomeAsUpEnabled(enable: Boolean) {
        (activity as BaseActivity).supportActionBar?.setDisplayHomeAsUpEnabled(enable)
    }
}