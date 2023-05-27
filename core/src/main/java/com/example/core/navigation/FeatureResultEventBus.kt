package com.example.core.navigation

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface FeatureResultListener {
    fun listen(): Observable<FeatureEvent>
}

interface FeatureResultEmitter {
    fun emit(result: FeatureEvent)
}

object FeatureResultEventBus : FeatureResultListener, FeatureResultEmitter {
    private val subject = PublishSubject.create<FeatureEvent>()

    override fun listen(): Observable<FeatureEvent> = subject.hide()

    override fun emit(result: FeatureEvent) {
        subject.onNext(result)
    }
}

