package com.example.afeela.di.module

import com.example.data_source_impl.repository.api.ItunesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {
    @Provides
    fun provideService(retrofit: Retrofit): ItunesApi {
        return retrofit.create(ItunesApi::class.java)
    }
}