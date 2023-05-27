package com.example.core.presentation.livedata

import androidx.lifecycle.MutableLiveData

class LiveDataProxy<T> internal constructor(internal val liveDataInternal: MutableLiveData<T>)