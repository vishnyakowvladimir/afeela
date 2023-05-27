package com.example.itunes.presentation.itunesList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain_models.ItunesTrack
import com.example.itunes_impl.databinding.ViewHolderTrackListBinding

class AdapterItunesTrackList(private val onItemClicked: ((track: ItunesTrack) -> Unit)) :
    ListAdapter<ItunesTrack, ViewHolderTrackList>(ItunesListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTrackList {
        val binding =
            ViewHolderTrackListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderTrackList(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderTrackList, position: Int) {
        prepareViews(holder)
        setListeners(holder)
    }

    override fun getItemCount(): Int {
        return currentList.count()
    }

    private fun prepareViews(viewHolder: ViewHolderTrackList) {
        val track = currentList[viewHolder.layoutPosition]

        viewHolder.binding.imageViewTrack.image = track.artworkUrl100
        viewHolder.binding.textViewTitle.text = track.trackName
        viewHolder.binding.textViewArtistName.text = track.artistName
    }

    private fun setListeners(viewHolder: ViewHolderTrackList) {
        viewHolder.binding.root.setOnClickListener {
            val track = currentList[viewHolder.layoutPosition]
            onItemClicked.invoke(track)
        }
    }
}