package com.example.itunes.presentation

import com.example.domain_models.ItunesTrack
import com.example.itunes.presentation.itunesDetails.ItunesDetailsFragment
import com.example.itunes.presentation.itunesList.ItunesListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun itunesListFragment() = FragmentScreen { ItunesListFragment.newInstance() }
    fun itunesDetailsFragment(track: ItunesTrack) =
        FragmentScreen { ItunesDetailsFragment.newInstance(track) }
}