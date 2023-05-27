package com.example.afeela.di.module

import android.content.Context
import com.example.core.utils.StringProvider
import com.example.core.utils.StringProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideStringProvider(context: Context): StringProvider {
        return StringProviderImpl(context)
    }
}