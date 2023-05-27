package com.example.afeela.presentation

import com.example.afeela.di.component.MainAppComponent
import com.example.core.presentation.application.BaseApplication

class MainApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        (MainAppComponent
            .builder()
            .dependencies(applicationContext)
            .build() as MainAppComponent)
            .inject(this)
    }
}