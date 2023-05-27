package com.example.itunes.presentation.itunesList.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain_models.ItunesTrack

class ItunesListDiffCallback: DiffUtil.ItemCallback<ItunesTrack>() {
    override fun areItemsTheSame(oldItem: ItunesTrack, newItem: ItunesTrack): Boolean {
        return oldItem.trackId == newItem.trackId
    }

    override fun areContentsTheSame(oldItem: ItunesTrack, newItem: ItunesTrack): Boolean {
        return oldItem == newItem
    }
}