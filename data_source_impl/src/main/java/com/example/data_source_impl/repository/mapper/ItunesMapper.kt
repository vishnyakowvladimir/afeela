package com.example.data_source_impl.repository.mapper

import com.example.data_source_impl.repository.model.ItunesTrackDto
import com.example.domain_models.ItunesTrack

interface ItunesMapper {
    fun mapItunesTrackList(list: List<ItunesTrackDto>): List<ItunesTrack>
}