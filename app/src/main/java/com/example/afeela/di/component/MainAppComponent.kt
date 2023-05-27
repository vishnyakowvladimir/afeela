package com.example.afeela.di.component

import android.content.Context
import com.example.afeela.di.module.*
import com.example.afeela.presentation.MainActivity
import com.example.afeela.presentation.MainApplication
import com.example.core.di.ComponentSingletonHolder
import com.example.core.presentation.viewmodel.di.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NavigationModule::class,
        FeatureNavigationModule::class,
        ViewModelModule::class,
        FeatureHolderModule::class,
        StarterModule::class,
        RetrofitModule::class,
        RepositoryModule::class,
        InteractorModule::class,
        MapperModule::class,
        ApiModule::class,
        ViewModelFactoryModule::class,
    ]
)
interface MainAppComponent : MainAppComponentApi {
    fun inject(application: MainApplication)
    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainAppComponent
    }

    companion object :
        ComponentSingletonHolder<MainAppComponentApi, MainAppComponent, Context>(::createComponent) {
    }
}

private fun createComponent(context: Context): MainAppComponent {
    return DaggerMainAppComponent.factory().create(context)
}