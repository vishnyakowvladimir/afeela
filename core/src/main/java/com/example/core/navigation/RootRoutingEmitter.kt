package com.example.core.navigation

import androidx.fragment.app.FragmentManager

interface RootRoutingEmitter {
    fun emit(event: RootRoutingEvent)
    fun subscribe(fm: FragmentManager, container: Int)
    fun unsubscribe()
}