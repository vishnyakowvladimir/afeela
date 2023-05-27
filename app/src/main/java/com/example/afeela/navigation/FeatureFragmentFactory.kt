package com.example.afeela.navigation

import androidx.fragment.app.Fragment
import com.example.core.navigation.FeatureFragmentProvider
import com.example.core.navigation.NavigationEvent
import com.example.core.navigation.OpenItunesEvent

class FeatureFragmentFactory(
    private val itunesFragmentProvider: FeatureFragmentProvider<OpenItunesEvent>,
) {
    fun createFragment(event: NavigationEvent): Fragment? = when (event) {
        is OpenItunesEvent -> itunesFragmentProvider.provide(event)
    }
}