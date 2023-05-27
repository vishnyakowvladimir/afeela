package com.example.itunes.di.module

import com.example.core.di.PerFeature
import com.example.itunes.di.FeatureItunesStarterImpl
import com.example.itunes_api.FeatureItunesStarter
import dagger.Binds
import dagger.Module

@Module
interface ItunesExternalModule {
    @Binds
    @PerFeature
    fun bindItunesStarter(starterImpl: FeatureItunesStarterImpl): FeatureItunesStarter
}