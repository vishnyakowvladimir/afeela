package com.example.afeela.navigation

import android.os.Looper
import androidx.fragment.app.FragmentManager
import com.example.core.extension.showFragment
import com.example.core.navigation.RootRoutingEmitter
import com.example.core.navigation.RootRoutingEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import io.reactivex.rxkotlin.subscribeBy

class RootRoutingHandlerImpl : RootRoutingEmitter {
    private val subject = PublishSubject.create<RootRoutingEvent>()
    private var cacheSubject = ReplaySubject.create<RootRoutingEvent>()
    private val disposable = CompositeDisposable()
    private var fragmentManager: FragmentManager? = null
    private var containerID: Int? = null

    override fun emit(event: RootRoutingEvent) {
        if (fragmentManager != null) {
            subject.onNext(event)
        } else {
            cacheSubject.onNext(event)
        }
    }

    override fun subscribe(fm: FragmentManager, container: Int) {
        fragmentManager = fm
        containerID = container

        cacheSubject.onComplete()
        disposable.add(
            subject
                .startWith(cacheSubject)
                .concatMap {
                    if (Looper.getMainLooper().isCurrentThread) {
                        Observable.just(it)
                    } else {
                        Observable.just(it)
                            .observeOn(AndroidSchedulers.mainThread())
                    }
                }
                .subscribeBy(onNext = ::handleEvent, onError = {})
        )
    }

    override fun unsubscribe() {
        fragmentManager = null
        containerID = null
        disposable.clear()
        cacheSubject = ReplaySubject.create()
    }

    private fun handleEvent(event: RootRoutingEvent) {
        fragmentManager?.let { fm ->
            val container = containerID ?: return@let

            when (event) {
                is RootRoutingEvent.OpenScreen -> {
                    fm.showFragment(event.fragment, container, true)
                }

                is RootRoutingEvent.CloseScreen -> {
                    fm.popBackStack()
                }
            }
        }
    }
}