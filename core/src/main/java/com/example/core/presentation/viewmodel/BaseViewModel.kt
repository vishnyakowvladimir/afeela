package com.example.core.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.presentation.livedata.LiveDataProxy
import com.example.core.presentation.livedata.LiveDataViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel(), LiveDataViewModel {

    private val compositeDisposable = CompositeDisposable()

    protected val errorDisposable = CompositeDisposable()

    val loadingState = state<Boolean>()
    val errorCommand = command<Throwable>()

    protected fun disposeSubscriptions() {
        errorDisposable.clear()
        compositeDisposable.clear()
    }

    final override fun <T> state(initialValue: T?): LiveDataProxy<T> = super.state(initialValue)

    final override fun <T> command(): LiveDataProxy<T> = super.command()

    override fun onCleared() {
        super.onCleared()
        disposeSubscriptions()
    }

    protected fun Disposable.untilClear() {
        compositeDisposable.add(this)
    }

}