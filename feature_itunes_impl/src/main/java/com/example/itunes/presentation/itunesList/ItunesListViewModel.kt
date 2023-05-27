package com.example.itunes.presentation.itunesList

import com.example.core.presentation.viewmodel.BaseViewModel
import com.example.data_sdk_api.domain.ItunesInteractor
import com.example.itunes.presentation.Screens
import com.example.itunes.presentation.itunesList.mvi.ItunesTrackListEvent
import com.example.itunes.presentation.itunesList.mvi.ItunesTrackListState
import com.github.terrakok.cicerone.Router
import javax.inject.Inject
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ItunesListViewModel @Inject constructor(
    private val interactor: ItunesInteractor,
    private val converter: ItunesListConverter,
    private val router: Router,
) : BaseViewModel() {
    val state = state<ItunesTrackListState>()

    init {
        loadItunesTracks()
    }

    fun onEvent(event: ItunesTrackListEvent) {
        when (event) {
            is ItunesTrackListEvent.OnItemClicked -> {
                router.navigateTo(Screens.itunesDetailsFragment(event.track))
            }
        }
    }

    private fun loadItunesTracks() {
        interactor
            .loadItunesTracks(
                offset = 0,
                limit = 100,
                term = "Often overlooked",
            )
            .subscribeOn(Schedulers.io())
            .subscribeBy(
                onSuccess = { items ->
                    state.postValue(converter.createState(items))
                },
                onError = {
                    state.postValue(converter.createState(null))
                }
            )
            .untilClear()
    }
}