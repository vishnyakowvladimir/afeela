package com.example.data_source_api.repository

import com.example.domain_models.ItunesTrack
import io.reactivex.Single

interface ItunesRepository {
    fun loadItunesTracks(offset: Int, limit: Int, term: String): Single<List<ItunesTrack>>
}