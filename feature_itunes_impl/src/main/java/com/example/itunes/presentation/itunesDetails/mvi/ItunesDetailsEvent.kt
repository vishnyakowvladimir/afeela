package com.example.itunes.presentation.itunesDetails.mvi

sealed class ItunesDetailsEvent {
    object OnBackPressed : ItunesDetailsEvent()
}