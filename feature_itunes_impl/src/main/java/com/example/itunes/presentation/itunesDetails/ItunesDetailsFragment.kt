package com.example.itunes.presentation.itunesDetails

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.core.extension.parcelable
import com.example.core.presentation.fragment.BindingFragment
import com.example.domain_models.ItunesTrack
import com.example.itunes.di.ItunesComponent
import com.example.itunes.presentation.itunesDetails.mvi.ItunesDetailsEvent
import com.example.itunes_impl.databinding.FragmentItunesDetailsBinding
import javax.inject.Inject

class ItunesDetailsFragment :
    BindingFragment<FragmentItunesDetailsBinding>(FragmentItunesDetailsBinding::inflate) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ItunesDetailsViewModel by viewModels { viewModelFactory }

    private val track: ItunesTrack? by lazy { arguments?.parcelable(BUNDLE_KEY_TRACK) }

    override fun onCreate(savedInstanceState: Bundle?) {
        ItunesComponent.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()
        setDisplayHomeAsUpEnabled(true)
        setTitle(track?.trackName)
        binding.run {
            imageViewTrack.image = track?.artworkUrl100
            textViewTitle.text = track?.trackName
            textViewArtistName.text = track?.artistName
        }
    }

    override fun onBackPressed() {
        viewModel.onEvent(ItunesDetailsEvent.OnBackPressed)
    }

    companion object {
        private const val BUNDLE_KEY_TRACK = "BUNDLE_KEY_TRACK"

        fun newInstance(track: ItunesTrack): ItunesDetailsFragment {
            return ItunesDetailsFragment().apply {
                arguments = bundleOf(BUNDLE_KEY_TRACK to track)
            }
        }
    }
}