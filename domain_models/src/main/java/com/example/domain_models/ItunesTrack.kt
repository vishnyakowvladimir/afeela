package com.example.domain_models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItunesTrack(
    val trackId: Long,
    var trackName: String,
    var artistName: String,
    var collectionName: String,
    var artworkUrl100: String,
) : Parcelable