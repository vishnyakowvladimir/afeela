package com.example.core.navigation

import androidx.fragment.app.Fragment

interface FeatureFragmentProvider<in T : NavigationEvent> {
    fun provide(event: T): Fragment?
}