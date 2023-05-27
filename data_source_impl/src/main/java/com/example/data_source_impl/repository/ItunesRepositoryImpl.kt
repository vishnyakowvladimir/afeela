package com.example.data_source_impl.repository

import com.example.data_source_api.repository.ItunesRepository
import com.example.data_source_impl.repository.api.ItunesApi
import com.example.data_source_impl.repository.mapper.ItunesMapper
import com.example.domain_models.ItunesTrack
import io.reactivex.Single

class ItunesRepositoryImpl(
    private val api: ItunesApi,
    private val mapper: ItunesMapper,
    ) : ItunesRepository {
    override fun loadItunesTracks(offset: Int, limit: Int, term: String): Single<List<ItunesTrack>> {
        return api
            .loadItunesTrackList(offset = offset, limit = limit, term = term)
            .map(mapper::mapItunesTrackList)
    }
}