package com.example.afeela.di.featureHolder

import com.example.core.di.FeatureHolder
import com.example.core.navigation.FeatureResultEmitter
import com.example.core.utils.StringProvider
import com.example.data_sdk_api.domain.ItunesInteractor
import com.example.itunes.di.ItunesComponent
import com.example.itunes.di.ItunesDependencies
import com.example.itunes_api.FeatureItunesApi

class ItunesFeatureHolder(
    private val itunesInteractor: ItunesInteractor,
    private val stringProvider: StringProvider,
    private val featureResultEmitter: FeatureResultEmitter,
) : FeatureHolder<FeatureItunesApi>() {
    override fun getFeatureApiInner(): FeatureItunesApi = ItunesComponent.builder()
        .dependencies(
            createItunesDependencies(
                itunesInteractor = itunesInteractor,
                stringProvider = stringProvider,
                featureResultEmitter = featureResultEmitter,
            )
        )
        .build()

    private fun createItunesDependencies(
        itunesInteractor: ItunesInteractor,
        stringProvider: StringProvider,
        featureResultEmitter: FeatureResultEmitter,
    ): ItunesDependencies = object : ItunesDependencies {
        override fun stringProvider(): StringProvider = stringProvider
        override fun itunesInteractor(): ItunesInteractor = itunesInteractor
        override fun featureResultEmitter(): FeatureResultEmitter = featureResultEmitter
    }
}