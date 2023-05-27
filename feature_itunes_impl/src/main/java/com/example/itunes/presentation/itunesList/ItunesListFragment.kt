package com.example.itunes.presentation.itunesList

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.core.presentation.fragment.BindingFragment
import com.example.itunes.di.ItunesComponent
import com.example.itunes.presentation.itunesList.adapter.AdapterItunesTrackList
import com.example.itunes.presentation.itunesList.mvi.ItunesTrackListEvent
import com.example.itunes.presentation.itunesList.mvi.ItunesTrackListState
import com.example.itunes_impl.R
import com.example.itunes_impl.databinding.FragmentItunesListBinding
import javax.inject.Inject

class ItunesListFragment :
    BindingFragment<FragmentItunesListBinding>(FragmentItunesListBinding::inflate) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ItunesListViewModel by viewModels { viewModelFactory }

    private val adapter by lazy { createAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        ItunesComponent.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()
        setDisplayHomeAsUpEnabled(false)
        setTitle(R.string.track_list_title)
        prepareRecyclerView()
    }

    override fun bindView() {
        super.bindView()
        viewModel.state bindTo ::handleState
    }

    private fun handleState(state: ItunesTrackListState) {
        binding.run {
            loader.isVisible = false
            placeholder.text = state.placeholderText
        }

        adapter.submitList(state.items)
    }

    private fun createAdapter(): AdapterItunesTrackList {
        return AdapterItunesTrackList(onItemClicked = { track ->
            viewModel.onEvent(ItunesTrackListEvent.OnItemClicked(track))
        })
    }

    private fun prepareRecyclerView() {
        binding.recyclerViewTrackList.adapter = adapter
    }

    companion object {
        fun newInstance(): ItunesListFragment {
            return ItunesListFragment()
        }
    }
}