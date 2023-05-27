package com.example.afeela.di.module

import com.example.core.utils.StringProvider
import com.example.data_source_impl.repository.mapper.ItunesMapper
import com.example.data_source_impl.repository.mapper.ItunesMapperImpl
import dagger.Module
import dagger.Provides

@Module
class MapperModule {
    @Provides
    fun provideItunesMapper(stringProvider: StringProvider): ItunesMapper {
        return ItunesMapperImpl(stringProvider)
    }
}