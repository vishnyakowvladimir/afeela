package com.example.afeela.di.module

import com.example.afeela.navigation.*
import com.example.core.navigation.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {
    @Singleton
    @Provides
    fun provideFeatureResultListener(): FeatureResultListener = FeatureResultEventBus

    @Singleton
    @Provides
    fun provideFeatureResultEmitter(): FeatureResultEmitter = FeatureResultEventBus

    @Singleton
    @Provides
    fun provideFeatureFragmentFactory(itunesFragmentProvider: ItunesFragmentProvider): FeatureFragmentFactory {
        return FeatureFragmentFactory(itunesFragmentProvider)
    }

    @Singleton
    @Provides
    fun provideBaseFeatureEventsListener(
        featureListener: FeatureResultListener,
        routingEmitter: RootRoutingEmitter,
        fragmentFactory: FeatureFragmentFactory,
    ): BaseFeatureEventsListener {
        return BaseFeatureEventsListener(
            featureListener = featureListener,
            routingEmitter = routingEmitter,
            fragmentFactory = fragmentFactory,
        )
    }

    @Singleton
    @Provides
    fun provideRootRootingEmitter(): RootRoutingEmitter {
        return RootRoutingHandlerImpl()
    }
}