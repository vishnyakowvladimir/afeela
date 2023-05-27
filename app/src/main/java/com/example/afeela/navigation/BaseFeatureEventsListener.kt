package com.example.afeela.navigation

import com.example.core.navigation.*
import io.reactivex.disposables.CompositeDisposable

class BaseFeatureEventsListener(
    private val featureListener: FeatureResultListener,
    private val routingEmitter: RootRoutingEmitter,
    private val fragmentFactory: FeatureFragmentFactory,
) {
    private val disposable = CompositeDisposable()

    fun subscribe() {
        if (disposable.size() == 0) {
            disposable.add(featureListener.listen()
                .subscribe(::handleResult))
        }
    }

    fun unsubscribe() {
        disposable.clear()
    }

    private fun handleResult(event: FeatureEvent) = when (event) {
        is SystemEvent -> handleSystemEvent(event)
        is NavigationEvent -> handleNavigationEvent(event)
    }

    private fun handleSystemEvent(event: SystemEvent) = when (event) {
        is CloseScreenEvent -> routingEmitter.emit(RootRoutingEvent.CloseScreen)
    }

    private fun handleNavigationEvent(event: NavigationEvent) {
        val fragment = fragmentFactory.createFragment(event)
        fragment?.let { routingEmitter.emit(RootRoutingEvent.OpenScreen(fragment)) }
    }
}