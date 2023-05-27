package com.example.itunes.di

import androidx.fragment.app.Fragment
import com.example.itunes.presentation.ItunesFlowFragment
import com.example.itunes_api.FeatureItunesStarter
import javax.inject.Inject

class FeatureItunesStarterImpl @Inject constructor() : FeatureItunesStarter {
    override fun getFlowFragment(): Fragment {
        return ItunesFlowFragment.newInstance()
    }
}