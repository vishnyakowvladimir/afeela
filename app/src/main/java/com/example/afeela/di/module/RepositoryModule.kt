package com.example.afeela.di.module

import com.example.data_source_api.repository.ItunesRepository
import com.example.data_source_impl.repository.ItunesRepositoryImpl
import com.example.data_source_impl.repository.api.ItunesApi
import com.example.data_source_impl.repository.mapper.ItunesMapper
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideItunesRepository(api: ItunesApi, mapper: ItunesMapper): ItunesRepository {
        return ItunesRepositoryImpl(api = api, mapper = mapper)
    }
}