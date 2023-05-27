package com.example.itunes.presentation.itunesList.mvi

import com.example.domain_models.ItunesTrack

sealed class ItunesTrackListEvent {
    data class OnItemClicked(val track: ItunesTrack) : ItunesTrackListEvent()
}