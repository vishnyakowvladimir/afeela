package com.example.core.presentation.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

open class BaseApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}