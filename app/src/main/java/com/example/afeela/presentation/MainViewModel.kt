package com.example.afeela.presentation

import com.example.core.navigation.FeatureResultEmitter
import com.example.core.navigation.OpenItunesEvent
import com.example.core.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val featureResultEmitter: FeatureResultEmitter
) : BaseViewModel() {

    fun start() {
        featureResultEmitter.emit(OpenItunesEvent)
    }
}