package com.example.itunes.presentation.itunesList.mvi

import com.example.domain_models.ItunesTrack

data class ItunesTrackListState(
    val items: List<ItunesTrack> = emptyList(),
    val placeholderText: String = "",
)