package com.example.itunes.di.module

import androidx.lifecycle.ViewModel
import com.example.core.presentation.viewmodel.di.ViewModelFactoryModule
import com.example.core.presentation.viewmodel.di.ViewModelKey
import com.example.itunes.presentation.itunesDetails.ItunesDetailsViewModel
import com.example.itunes.presentation.itunesList.ItunesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
abstract class ItunesViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ItunesListViewModel::class)
    abstract fun bindItunesListViewModel(viewModel: ItunesListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ItunesDetailsViewModel::class)
    abstract fun bindItunesDetailsViewModel(viewModel: ItunesDetailsViewModel): ViewModel
}