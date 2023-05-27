package com.example.core.navigation.di

import com.example.core.di.PerFeature
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class CiceroneModule {
    @PerFeature
    @Provides
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @PerFeature
    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.getNavigatorHolder()

    @PerFeature
    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router
}