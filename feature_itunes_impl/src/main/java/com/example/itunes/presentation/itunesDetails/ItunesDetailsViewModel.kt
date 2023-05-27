package com.example.itunes.presentation.itunesDetails

import com.example.core.presentation.viewmodel.BaseViewModel
import com.example.itunes.presentation.itunesDetails.mvi.ItunesDetailsEvent
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ItunesDetailsViewModel @Inject constructor(
    private val router: Router,
) : BaseViewModel() {
    fun onEvent(event: ItunesDetailsEvent) {
        when(event) {
            is ItunesDetailsEvent.OnBackPressed -> router.exit()
        }
    }
}