package com.example.core.di

abstract class ModuleHolder<T : ModuleApi> {

    private var moduleApi: T? = null

    fun getFeatureApi(): T = getFeatureApiInner().also { moduleApi = it }

    protected abstract fun getFeatureApiInner(): T
}