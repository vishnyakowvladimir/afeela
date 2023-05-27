package com.example.data_source_impl.repository.model

data class ItunesTrackDto(
    val trackId: Long?,
    var trackName: String?,
    var artistName: String?,
    var collectionName: String?,
    var artworkUrl100: String?,
)