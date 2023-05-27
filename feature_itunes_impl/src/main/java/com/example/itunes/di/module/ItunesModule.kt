package com.example.itunes.di.module

import com.example.core.di.PerFeature
import com.example.core.utils.StringProvider
import com.example.itunes.presentation.itunesList.ItunesListConverter
import dagger.Module
import dagger.Provides

@Module
class ItunesModule {
    @PerFeature
    @Provides
    fun provideItunesListConverter(stringProvider: StringProvider): ItunesListConverter = ItunesListConverter(stringProvider)
}