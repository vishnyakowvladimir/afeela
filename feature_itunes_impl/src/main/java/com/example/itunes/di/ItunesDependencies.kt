package com.example.itunes.di

import com.example.core.navigation.FeatureResultEmitter
import com.example.core.utils.StringProvider
import com.example.data_sdk_api.domain.ItunesInteractor

interface ItunesDependencies {
    fun stringProvider(): StringProvider
    fun featureResultEmitter(): FeatureResultEmitter
    fun itunesInteractor(): ItunesInteractor
}