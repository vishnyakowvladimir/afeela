package com.example.core.presentation.fragment

interface UiComponent {
    fun initView() = Unit

    fun listenUiUpdates() = Unit

    fun bindView() = Unit
}