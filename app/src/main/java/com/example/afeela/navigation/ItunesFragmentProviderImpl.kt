package com.example.afeela.navigation

import androidx.fragment.app.Fragment
import com.example.core.navigation.FeatureFragmentProvider
import com.example.core.navigation.OpenItunesEvent
import com.example.itunes_api.FeatureItunesStarter

interface ItunesFragmentProvider : FeatureFragmentProvider<OpenItunesEvent>

class ItunesFragmentProviderImpl(
    private val starter: FeatureItunesStarter,
) : ItunesFragmentProvider {
    override fun provide(event: OpenItunesEvent): Fragment {
        return starter.getFlowFragment()
    }
}