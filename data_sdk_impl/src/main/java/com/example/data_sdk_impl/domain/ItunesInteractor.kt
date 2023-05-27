package com.example.data_sdk_impl.domain

import com.example.data_sdk_api.domain.ItunesInteractor
import com.example.data_source_api.repository.ItunesRepository
import com.example.domain_models.ItunesTrack
import io.reactivex.Single

class ItunesInteractorImpl(private val itunesRepository: ItunesRepository) : ItunesInteractor {
    override fun loadItunesTracks(
        offset: Int,
        limit: Int,
        term: String
    ): Single<List<ItunesTrack>> {
        return itunesRepository.loadItunesTracks(
            offset = offset,
            limit = limit,
            term = term,
        )
    }
}