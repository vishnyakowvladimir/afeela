package com.example.data_sdk_api.domain

import com.example.domain_models.ItunesTrack
import io.reactivex.Single

interface ItunesInteractor {
    fun loadItunesTracks(offset: Int, limit: Int, term: String): Single<List<ItunesTrack>>
}