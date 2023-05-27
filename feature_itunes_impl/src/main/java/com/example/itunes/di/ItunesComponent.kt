package com.example.itunes.di

import com.example.core.di.ComponentSingletonHolder
import com.example.core.di.PerFeature
import com.example.core.navigation.di.CiceroneModule
import com.example.itunes.di.module.ItunesExternalModule
import com.example.itunes.di.module.ItunesModule
import com.example.itunes.di.module.ItunesViewModelModule
import com.example.itunes.presentation.ItunesFlowFragment
import com.example.itunes.presentation.itunesDetails.ItunesDetailsFragment
import com.example.itunes.presentation.itunesList.ItunesListFragment
import com.example.itunes_api.FeatureItunesApi
import dagger.Component

@Component(
    modules = [
        ItunesExternalModule::class,
        ItunesViewModelModule::class,
        ItunesModule::class,
        CiceroneModule::class,
    ],
    dependencies = [ItunesDependencies::class]
)
@PerFeature
abstract class ItunesComponent : FeatureItunesApi {
    abstract fun inject(fragment: ItunesFlowFragment)
    abstract fun inject(fragment: ItunesListFragment)
    abstract fun inject(fragment: ItunesDetailsFragment)

    companion object :
        ComponentSingletonHolder<FeatureItunesApi, ItunesComponent, ItunesDependencies>(::createComponent) {
    }
}

private fun createComponent(itunesDependencies: ItunesDependencies): ItunesComponent =
    DaggerItunesComponent.builder()
        .itunesDependencies(itunesDependencies)
        .build()