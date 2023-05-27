package com.example.itunes.presentation.itunesList

import com.example.core.utils.StringProvider
import com.example.domain_models.ItunesTrack
import com.example.itunes.presentation.itunesList.mvi.ItunesTrackListState
import com.example.itunes_impl.R

class ItunesListConverter(private val stringProvider: StringProvider) {
    fun createState(items: List<ItunesTrack>?): ItunesTrackListState {
        return ItunesTrackListState(
            items = items.orEmpty(),
            placeholderText = buildPlaceholderText(items)
        )
    }

    private fun buildPlaceholderText(items: List<ItunesTrack>?): String {
        return when {
            items == null -> stringProvider.getString(R.string.track_list_error)
            items.isEmpty() -> stringProvider.getString(R.string.track_list_empty)
            else -> ""
        }
    }
}