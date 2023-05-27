package com.example.core.presentation.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

interface LiveDataView {
    val extensionsLifecycleOwner: LifecycleOwner

    private val <T> LiveDataProxy<T>.liveData: LiveData<T>
        get() = this.liveDataInternal

    infix fun <T> LiveDataProxy<T>.bindTo(consumer: ((T) -> Unit)) =
        this.liveData.observe(extensionsLifecycleOwner, Observer(consumer))

    infix fun LiveDataProxy<Unit>.bindTo(consumer: (() -> Unit)) =
        this.liveData.observe(extensionsLifecycleOwner, Observer { consumer.invoke() })
}