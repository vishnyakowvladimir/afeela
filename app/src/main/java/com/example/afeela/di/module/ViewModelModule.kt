package com.example.afeela.di.module

import androidx.lifecycle.ViewModel
import com.example.afeela.presentation.MainViewModel
import com.example.core.presentation.viewmodel.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(viewModel: MainViewModel): ViewModel
}