package com.example.itunes_api

import androidx.fragment.app.Fragment
import com.example.core.di.FeatureApi
import com.example.core.di.FeatureStarter

interface FeatureItunesApi : FeatureApi {
    val featureItunesStarter: FeatureItunesStarter
}

interface FeatureItunesStarter : FeatureStarter {
    fun getFlowFragment(): Fragment
}