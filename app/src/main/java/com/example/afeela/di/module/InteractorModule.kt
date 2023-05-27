package com.example.afeela.di.module

import com.example.data_sdk_api.domain.ItunesInteractor
import com.example.data_sdk_impl.domain.ItunesInteractorImpl
import com.example.data_source_api.repository.ItunesRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {
    @Provides
    fun provideItunesInteractor(itunesRepository: ItunesRepository): ItunesInteractor {
        return ItunesInteractorImpl(itunesRepository)
    }
}