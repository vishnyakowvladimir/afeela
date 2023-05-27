package com.example.afeela.di.module

import com.example.afeela.di.featureHolder.ItunesFeatureHolder
import com.example.itunes_api.FeatureItunesStarter
import dagger.Module
import dagger.Provides

@Module
class StarterModule {
    @Provides
    fun provideItunesStarter(featureHolder: ItunesFeatureHolder): FeatureItunesStarter {
        return featureHolder.getFeatureApi().featureItunesStarter
    }
}