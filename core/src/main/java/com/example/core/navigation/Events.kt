package com.example.core.navigation

import androidx.fragment.app.Fragment

sealed class FeatureEvent
sealed class SystemEvent : FeatureEvent()
sealed class NavigationEvent() : FeatureEvent()

object CloseScreenEvent : SystemEvent()

object OpenItunesEvent : NavigationEvent()

sealed class RootRoutingEvent {
    class OpenScreen(val fragment: Fragment) : RootRoutingEvent()
    object CloseScreen : RootRoutingEvent()
}