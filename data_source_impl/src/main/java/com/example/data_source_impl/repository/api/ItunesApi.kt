package com.example.data_source_impl.repository.api

import com.example.data_source_impl.repository.model.ItunesTrackDto
import com.serjltt.moshi.adapters.Wrapped
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesApi {
    @GET("search")
    @Wrapped(path = ["results"])
    fun loadItunesTrackList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("term") term: String
    ): Single<List<ItunesTrackDto>>
}