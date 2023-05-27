package com.example.core.presentation.livedata

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData

interface LiveDataViewModel {

    fun <T> state(initialValue: T? = null): LiveDataProxy<T> {
        val liveData = if (initialValue != null) {
            MutableLiveData<T>(initialValue)
        } else {
            MutableLiveData<T>()
        }

        return LiveDataProxy(liveData)
    }

    fun <T> command(): LiveDataProxy<T> = LiveDataProxy(OneShotLiveData())

    private val <T> LiveDataProxy<T>.liveData: MutableLiveData<T>
        get() = this.liveDataInternal

    fun <T> LiveDataProxy<T>.postValue(value: T) = this.liveData.postValue(value)

    @MainThread
    fun <T> LiveDataProxy<T>.setValue(value: T) {
        liveData.value = value
    }

    val <T> LiveDataProxy<T>.value: T?
        get() = this.liveData.value
}

