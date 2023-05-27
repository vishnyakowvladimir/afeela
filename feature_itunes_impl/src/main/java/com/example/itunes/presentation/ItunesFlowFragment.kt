package com.example.itunes.presentation

import android.os.Bundle
import com.example.core.presentation.fragment.FlowFragment
import com.example.itunes.di.ItunesComponent
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import javax.inject.Inject

class ItunesFlowFragment : FlowFragment() {
    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        ItunesComponent.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun getLaunchScreen(): Screen {
        return Screens.itunesListFragment()
    }

    companion object {
        fun newInstance(): ItunesFlowFragment {
            return ItunesFlowFragment()
        }
    }
}