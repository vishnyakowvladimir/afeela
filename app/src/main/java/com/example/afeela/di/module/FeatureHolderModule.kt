package com.example.afeela.di.module

import com.example.afeela.di.featureHolder.ItunesFeatureHolder
import com.example.core.navigation.FeatureResultEmitter
import com.example.core.utils.StringProvider
import com.example.data_sdk_api.domain.ItunesInteractor
import dagger.Module
import dagger.Provides

@Module
class FeatureHolderModule {
    @Provides
    fun provideItunesFeatureHolder(
        itunesInteractor: ItunesInteractor,
        stringProvider: StringProvider,
        featureResultEmitter: FeatureResultEmitter,
    ): ItunesFeatureHolder {
        return ItunesFeatureHolder(
            itunesInteractor = itunesInteractor,
            stringProvider = stringProvider,
            featureResultEmitter = featureResultEmitter,
        )
    }
}