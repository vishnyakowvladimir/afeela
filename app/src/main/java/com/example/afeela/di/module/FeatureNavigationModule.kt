package com.example.afeela.di.module

import com.example.afeela.navigation.ItunesFragmentProvider
import com.example.afeela.navigation.ItunesFragmentProviderImpl
import com.example.itunes_api.FeatureItunesStarter
import dagger.Module
import dagger.Provides

@Module
class FeatureNavigationModule {
    @Provides
    fun provideItunesFragmentProvider(starter: FeatureItunesStarter): ItunesFragmentProvider {
        return ItunesFragmentProviderImpl(starter)
    }
}