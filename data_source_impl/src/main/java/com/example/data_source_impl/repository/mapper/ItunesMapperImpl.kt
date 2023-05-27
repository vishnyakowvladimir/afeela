package com.example.data_source_impl.repository.mapper

import com.example.core.utils.StringProvider
import com.example.data_source_impl.R
import com.example.data_source_impl.repository.model.ItunesTrackDto
import com.example.domain_models.ItunesTrack

class ItunesMapperImpl(private val stringProvider: StringProvider) : ItunesMapper {
    override fun mapItunesTrackList(list: List<ItunesTrackDto>): List<ItunesTrack> {
        return list.map { track -> mapItunesTrack(track) }
    }

    private fun mapItunesTrack(dto: ItunesTrackDto): ItunesTrack {
        return ItunesTrack(
            trackId = dto.trackId ?: 0,
            trackName = dto.trackName ?: stringProvider.getString(R.string.unknown),
            artistName = dto.artistName ?: stringProvider.getString(R.string.unknown),
            collectionName = dto.collectionName ?: stringProvider.getString(R.string.unknown),
            artworkUrl100 = dto.artworkUrl100 ?: stringProvider.getString(R.string.unknown),
        )
    }
}